package javaPrograms.PracticePrograms;

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
import io.restassured.path.json.JsonPath;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.*;
import org.json.JSONObject;
import java.util.Base64;

/**
 * @since May 8, 2020
 * @author Deepak Rai
 */
public class GmailRunner {

  private static final String APPLICATION_NAME = "DeepakAPILearning";
  private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
  private static final String USER_ID = "me";

  /**
   * Global instance of the scopes required by this quick start. If modifying these scopes, delete
   * your previously saved tokens / folder.
   */
  private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);

  private static final String CREDENTIALS_FILE_PATH =
      System.getProperty("user.dir")
          + File.separator
          + "src"
          + File.separator
          + "main"
          + File.separator
          + "resources"
          + File.separator
          + "Credentials"
          + File.separator
          + "GMAILCredential.json";

  private static final String TOKENS_DIRECTORY_PATH =
      System.getProperty("user.dir")
          + File.separator
          + "src"
          + File.separator
          + "main"
          + File.separator
          + "resources"
          + File.separator
          + "Credentials";

  /**
   * Creates an authorized Credential object.
   *
   * @param HTTP_TRANSPORT The network HTTP Transport.
   * @return An authorized Credential object.
   * @throws IOException If the credentials.json file cannot be found.
   */
  private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
      throws IOException {
    // Load client secrets
    InputStream in = new FileInputStream(CREDENTIALS_FILE_PATH);
    //  InputStream in = GmailRunner.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
    GoogleClientSecrets clientSecrets =
        GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

    // Build flow and trigger user authorization request.
    GoogleAuthorizationCodeFlow flow =
        new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
            .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
            .setAccessType("offline")
            .setApprovalPrompt("force")
            .build();
    LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
    return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
  }

  public static Gmail getService() throws GeneralSecurityException, IOException {
    // Build a new authorized API client service
    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    return new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
        .setApplicationName(APPLICATION_NAME)
        .build();
  }

  public static List<Message> listMessagesMatchingQuery(Gmail service, String userId, String query)
      throws IOException {

    ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();
    List<Message> messages = new ArrayList<>();

    while (response.getMessages() != null) {
      messages.addAll(response.getMessages());
      if (response.getNextPageToken() != null) {
        String pageToken = response.getNextPageToken();
        response =
            service.users().messages().list(userId).setQ(query).setPageToken(pageToken).execute();
      } else {
        break;
      }
    }
    return messages;
  }

  public static Message getMessage(Gmail service, String userId, List<Message> messages, int index)
      throws IOException {
    return service.users().messages().get(userId, messages.get(index).getId()).execute();
  }

  public static HashMap<String, String> getGmailData(String query) {
    try {
      Gmail service = getService();
      List<Message> messages = listMessagesMatchingQuery(service, USER_ID, query);
      Message message = getMessage(service, USER_ID, messages, 0);
      JsonPath jp = new JsonPath(message.toString());
      String subject = jp.getString("payload.headers.find {it.name== 'Subject'}.value");
      String body =
          new String(Base64.getDecoder().decode(jp.getString("payload.parts[0].body.data")));
      String link = null;
      String[] arr = body.split("\n");
      for (String s : arr) {
        s = s.trim();
        if (s.contains("http") || s.contains("https")) {
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
    int countOfMails;
    try {
      Gmail service = getService();
      countOfMails = service.users().getProfile(USER_ID).execute().getMessagesTotal();
    } catch (Exception e) {
      System.out.println("Exception log: " + e);
      countOfMails = -1;
    }
    return countOfMails;
  }

  private static List<Message> getMessages(
      Gmail service, ListMessagesResponse listMessagesResponse) {
    List<Message> messages = new ArrayList<>();

    try {
      while (listMessagesResponse.getMessages() != null) {
        messages.addAll(listMessagesResponse.getMessages());

        if (listMessagesResponse.getNextPageToken() != null) {
          String pageToken = listMessagesResponse.getNextPageToken();
          listMessagesResponse =
              service.users().messages().list(USER_ID).setPageToken(pageToken).execute();
        } else {
          break;
        }
      }
      return messages;
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    }
  }

  public static boolean isMailExist(String messageTitle) {
    try {
      Gmail service = getService();
      ListMessagesResponse response =
          service.users().messages().list(USER_ID).setQ("subject:" + messageTitle).execute();

      //  System.out.println(response.toPrettyString());
      List<Message> messages = getMessages(service, response);
      System.out.println("Count of Mails with subject: " + messageTitle + " = " + messages.size());
      return messages.size() != 0;
    } catch (Exception e) {
      System.out.println("Exception log: " + e);
      return false;
    }
  }

  /**
   * Immediately and permanently deletes the specified thread. This operation cannot be undone.
   * Prefer threads.trash instead.
   *
   * @param threadId ID of Thread to delete.
   * @throws IOException Exception
   * @throws GeneralSecurityException Exception
   */
  public static void deleteThread(String threadId) throws IOException, GeneralSecurityException {
    Gmail service = getService();
    service.users().threads().delete(USER_ID, threadId).execute();
    System.out.println("Thread with id: " + threadId + " deleted successfully.");
  }

  /**
   * Immediately trashes vthe specified thread.
   *
   * @param threadId ID of Thread to delete.
   * @throws IOException Exception
   * @throws GeneralSecurityException Exception
   */
  public static void trashThread(String threadId) throws IOException, GeneralSecurityException {
    Gmail service = getService();
    service.users().threads().trash(USER_ID, threadId).execute();
    System.out.println("Thread with id: " + threadId + " trashed successfully.");
  }

  private static String getAccessToken() {

    try {
      Map<String, Object> params = new LinkedHashMap<>();
      params.put("grant_type", "refresh_token");
      params.put(
          "client_id",
          "535553685908-5f236gkfjug3vc33165plvebve8s7qln.apps.googleusercontent.com"); // Replace
      // this
      params.put("client_secret", "vv4lW4BWga0nRAxZhbyd6KEE"); // Replace this
      params.put("refresh_token", "YOUR_REFRESH_TOKEN"); // Replace this

      StringBuilder postData = new StringBuilder();
      for (Map.Entry<String, Object> param : params.entrySet()) {
        if (postData.length() != 0) {
          postData.append('&');
        }
        postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
        postData.append('=');
        postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
      }
      byte[] postDataBytes = postData.toString().getBytes("UTF-8");

      URL url = new URL("https://accounts.google.com/o/oauth2/token");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setDoOutput(true);
      con.setUseCaches(false);
      con.setRequestMethod("POST");
      con.getOutputStream().write(postDataBytes);

      BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      StringBuffer buffer = new StringBuffer();
      for (String line = reader.readLine(); line != null; line = reader.readLine()) {
        buffer.append(line);
      }

      JSONObject json = new JSONObject(buffer.toString());
      String accessToken = json.getString("access_token");
      return accessToken;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  /**
   * {main method to call different utilities for GMAIL}
   *
   * @param args arguments
   * @author deepak
   * @throws GeneralSecurityException GeneralSecurityException
   * @throws IOException IOException
   */
  public static void main(String[] args) throws IOException, GeneralSecurityException {

    HashMap<String, String> hm =
        getGmailData("subject:IMPORTANT: Please Review and Book Your Appt");
    System.out.println(hm.get("subject"));
    System.out.println("===========");
    System.out.println(hm.get("body"));
    System.out.println("===========");
    System.out.println(hm.get("link"));

    System.out.println("===========");
    System.out.println("Total count of email(entire mailbox) is: " + getTotalCountOfMails());

    System.out.println("===========");
    boolean exist = isMailExist("IMPORTANT: Please Review and Book Your Appt");
    System.out.println("Mail with given subject exist or not: " + exist);

    System.out.println(getAccessToken());

    // trashThread("176e5032b2b9249f");

    //    System.setProperty("webdriver.chrome.driver", CommonConstants.DRIVERPATH_CHROME);
    //    WebDriver driver = new ChromeDriver();
    //    driver.get("http://google.com");
    //    ((JavascriptExecutor) driver).executeScript("window.open()");
    //    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    //    driver.switchTo().window(tabs.get(1));
    //    driver.get(hm.get("link"));
    //    driver.quit();
  }
} // end of class GmailRunner
