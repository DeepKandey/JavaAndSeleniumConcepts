/**
 * 
 */
package javaPrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.Thread;

import io.restassured.path.json.JsonPath;

/**
 * @since May 8, 2020
 * @author Deepak Rai
 *
 */
public class GmailRunner {

	private static final String APPLICATION_NAME = "DeepakAPILearning";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String USER_ID = "me";

	/**
	 * Global instance of the scopes required by this quick start. If modifying
	 * these scopes, delete your previously saved tokens / folder.
	 */

	private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);
	private static final String CREDENTIALS_FILE_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "main" + File.separator + "resources" + File.separator + "Credentials" + File.separator
			+ "GMAILcredential.json";

	private static final String TOKENS_DIRECTORY_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "main" + File.separator + "resources" + File.separator + "Credentials";

	/**
	 * Creates an authorized Credential object.
	 * 
	 * @param HTTP_TRANSPORT The network HTTP Transport.
	 * @return An authorized Credential object.
	 * @throws IOException If the credentials.json file cannot be found.
	 */

	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
		// Load client secrets
		InputStream in = new FileInputStream(new File(CREDENTIALS_FILE_PATH));
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES).setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
						.setAccessType("offline").build();
		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(9999).build();
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}

	public static Gmail getService() throws GeneralSecurityException, IOException {
		// Build a new authorized API client service
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME).build();
		return service;
	}

	public static List<Message> listMessagesMatchingQuery(Gmail service, String userId, String query)
			throws IOException {

		ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();
		List<Message> messages = new ArrayList<>();

		while (response.getMessages() != null) {
			messages.addAll(response.getMessages());
			if (response.getNextPageToken() != null) {
				String pageToken = response.getNextPageToken();
				response = service.users().messages().list(userId).setQ(query).setPageToken(pageToken).execute();
			} else {
				break;
			}
		}
		return messages;
	}

	public static Message getMessage(Gmail service, String userId, List<Message> messages, int index)
			throws IOException {
		Message message = service.users().messages().get(userId, messages.get(index).getId()).execute();
		return message;
	}

	public static HashMap<String, String> getGmailData(String query) {
		try {
			Gmail service = getService();
			List<Message> messages = listMessagesMatchingQuery(service, USER_ID, query);
			Message message = getMessage(service, USER_ID, messages, 0);
			JsonPath jp = new JsonPath(message.toString());
			String subject = jp.getString("payload.headers.find {it.name== 'Subject'}.value");
			String body = new String(Base64.getDecoder().decode(jp.getString("payload.parts[0].body.data")));
			String link = null;
			String arr[] = body.split("\n");
			for (String s : arr) {
				s = s.trim();
				if (s.startsWith("http") || s.startsWith("https")) {
					link = s.trim();
				}
			}

			HashMap<String, String> hm = new HashMap<>();
			hm.put("subject", subject);
			hm.put("body", body);
			hm.put("link", link);
			return hm;
		} catch (Exception e) {
			System.out.println("email not found");
			throw new RuntimeException();
		}
	}

	public static int getTotalCountOfMails() {
		int size;
		try {
			Gmail service = getService();
			List<Thread> threads = service.users().threads().list(USER_ID).execute().getThreads();
			size = threads.size();
		} catch (Exception e) {
			System.out.println("Exception log: " + e);
			size = -1;
		}
		return size;
	}

	private static List<Message> getMessages(Gmail service, ListMessagesResponse response) {
		List<Message> messages = new ArrayList<>();

		try {
			while (response.getMessages() != null) {
				messages.addAll(response.getMessages());
	
				if (response.getNextPageToken() != null) {
					String pageToken = response.getNextPageToken();
					response = service.users().messages().list(USER_ID).setPageToken(pageToken).execute();
				} else {
					break;
				}
			}
			return messages;
		} catch (Exception e) {
			System.out.println("Exception log: " + e);
			return messages;
		}
	}

	public static boolean isMailExist(String messageTitle) {
		try {
			Gmail service = getService();
			ListMessagesResponse response = service.users().messages().list(USER_ID).setQ("subject:" + messageTitle)
					.execute();
			
			System.out.println(response.toPrettyString());
			List<Message> messages = getMessages(service,response);
			return messages.size() != 0;

		} catch (Exception e) {
			System.out.println("Exception log: " + e);
			return false;
		}
	}

	/**
	   * Immediately and permanently deletes the specified thread. This operation cannot
	   * be undone. Prefer threads.trash instead.
	   *
	   * @param service Authorized Gmail API instance.
	   * @param userId User's email address. The special value "me"
	   * can be used to indicate the authenticated user.
	   * @param threadId ID of Thread to delete.
	   * @throws IOException
	 * @throws GeneralSecurityException 
	   */
	  public static void deleteThread(String threadId)
	      throws IOException, GeneralSecurityException {
		  Gmail service= getService();
	    service.users().threads().delete(USER_ID, threadId).execute();
	    System.out.println("Thread with id: " + threadId + " deleted successfully.");
	  }
	  
	/**
	 * {@summary main method to call different utilities for GMAIL}
	 * 
	 * @param args
	 * @return void
	 * @author deepak
	 * @throws GeneralSecurityException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, GeneralSecurityException {

		/*
		 * HashMap<String, String> hm = getGmailData(
		 * "subject:Premium Receipt for your Max Life Insurance Policy");
		 * System.out.println(hm.get("subject")); System.out.println("===========");
		 * System.out.println(hm.get("body")); System.out.println("===========");
		 * System.out.println(hm.get("link"));
		 */

		System.out.println("===========");
		System.out.println("Total count of email is: " + getTotalCountOfMails());

		System.out.println("===========");
		boolean exist = isMailExist(
				"New link");
		
		//deleteThread("159646751328c046");
		System.out.println("title exist or not: " + exist);

	}
} // end of class GmailRunner