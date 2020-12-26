package javaPrograms.PracticePrograms;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	public static void main(String[] args) throws EmailException {
		SendEmail simpleEmail = new SendEmail();
		simpleEmail.sendSimpleEmail();
		simpleEmail.sendEmailWithAttachment();
	}

	private void sendSimpleEmail() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("deepak1234@gmail.com", "****"));
		email.setSSLOnConnect(true);
		email.setFrom("deepakggsipu@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("deepakggsipu@gmail.com");
		email.addCc("deepak.rai21@yahoo.com");
		email.send();
		System.out.println("Simple Email sent");
	}

	private void sendEmailWithAttachment() throws EmailException {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("Captcha.png");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Picture of John");
		attachment.setName("John");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("deepak1234ipu@gmail.com", "****"));
		email.setSSLOnConnect(true);
		email.setFrom("deepakggsipu@gmail.com", "Me");
		email.setSubject("The picture");
		email.setMsg("Here is the picture you wanted");
		email.addTo("deepakggsipu@gmail.com", "Deepak Rai");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();
		System.out.println("Simple Email with Attachement sent");
	}
}