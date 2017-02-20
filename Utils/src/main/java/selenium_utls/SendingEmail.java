package selenium_utls;

import helper.PropertiesReader;

import java.util.Arrays;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendingEmail {

	/**
	 * Executing Send Email method.
	 */
	public static void execute()

	{
		String path = PropertiesReader.readProperty("email_report_path");
		String[] to =  PropertiesReader.readProperty("to_emaiIDs").replace("\"", "").split("\\s*,\\s*") ;
		String[] cc =  PropertiesReader.readProperty("cc_emaiIDs").replace("\"", "").split("\\s*,\\s*") ;
		String[] bcc =  PropertiesReader.readProperty("bcc_emaiIDs").replace("\"", "").split("\\s*,\\s*") ;

		SendingEmail.sendMail(PropertiesReader.readProperty("userMailID"),
				PropertiesReader.readProperty("userPassword"),
				PropertiesReader.readProperty("smtp_url"),
				PropertiesReader.readProperty("smtp_port"), "true", "true",
				true, "javax.net.ssl.SSLSocketFactory", "false", to, cc, bcc,
				"testReports", "Please find the reports attached", path,
				"emailReports");

	}

	/**
	 * Sending email's based on the parameters.
	 * 
	 * @param userName
	 * @param passWord
	 * @param host
	 * @param port
	 * @param starttls
	 * @param auth
	 * @param debug
	 * @param socketFactoryClass
	 * @param fallback
	 * @param to
	 * @param cc
	 * @param bcc
	 * @param subject
	 * @param text
	 * @param attachmentPath
	 * @param attachmentName
	 * @return true or false based on email sending status.
	 */
	public static boolean sendMail(String userName, String passWord,
			String host, String port, String starttls, String auth,
			boolean debug, String socketFactoryClass, String fallback,
			String[] to, String[] cc, String[] bcc, String subject,
			String text, String attachmentPath, String attachmentName) {

		Properties props = new Properties();
		// Properties props=System.getProperties();
		props.put("mail.smtp.user", userName);
		props.put("mail.smtp.host", host);

		if (!"".equals(port))
			props.put("mail.smtp.port", port);

		if (!"".equals(starttls))
			props.put("mail.smtp.starttls.enable", starttls);
		props.put("mail.smtp.auth", auth);
		// props.put("mail.smtps.auth", "true")

		if (debug) {
			props.put("mail.smtp.debug", "true");
		} else {
			props.put("mail.smtp.debug", "false");
		}

		if (!"".equals(port))
			props.put("mail.smtp.socketFactory.port", port);

		if (!"".equals(fallback))
			props.put("mail.smtp.socketFactory.fallback", fallback);

		try {
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(debug);
			MimeMessage msg = new MimeMessage(session);
			msg.setText(text);
			msg.setSubject(subject);
			Multipart multipart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentPath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(attachmentName);
			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);
			msg.setFrom(new InternetAddress(PropertiesReader
					.readProperty("userMailID")));

			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to[i]));
			}

			for (int i = 0; i < cc.length; i++) {
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
						cc[i]));
			}

			for (int i = 0; i < bcc.length; i++) {
				msg.addRecipient(Message.RecipientType.BCC,
						new InternetAddress(bcc[i]));
			}

			msg.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(host, userName, passWord);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception mex) {
			mex.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		
	
		String str = PropertiesReader.readProperty("to_emaiIDs");
		String[] arr = null;

	
			    arr = PropertiesReader.readProperty("to_emaiIDs").replace("\"", "").split("\\s*,\\s*");
		 
		 
		 System.out.println(str);
		 
		 for (int i = 0 ; i < arr.length ; i ++)
		 System.out.println(arr[i]);
		
		
	}
}