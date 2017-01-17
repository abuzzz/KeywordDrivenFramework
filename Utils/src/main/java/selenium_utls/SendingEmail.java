package selenium_utls;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendingEmail {

	public static boolean sendMail(String userName, String passWord, String host, String port, String starttls,
			String auth, boolean debug, String socketFactoryClass, String fallback, String[] to, String[] cc,
			String[] bcc, String subject, String text, String err, String name) {

		
		Properties properties = new Properties();
		properties.put("mail.smtp.user", userName);
		properties.put("mail.smtp.host", host);
		if (!"".equals(port)) {
			properties.put("mail.smtp.port", port);
		}
		if (!"".equals(starttls)) {
			properties.put("mail.smtp.starttls.enable", starttls);
			properties.put("mail.smtp.auth", auth);
		}
		if (debug) {
			properties.put("mail.smtp.debug", "true");
		} else {
			properties.put("mail.smtp.debug", "false");
		}
		if (!"".equals(port)) {
			properties.put("mail.smtp.socketFactory.port", port);
		}
		if (!"".equals(socketFactoryClass)) {
			properties.put("mail.smtp.socketFactory.class", socketFactoryClass);
		}
		if (!"".equals(fallback)) {
			properties.put("mail.smtp.socketFactory.fallback", fallback);
		}
		try {
			Session session = Session.getDefaultInstance(properties, null);
			session.setDebug(debug);
			MimeMessage msg = new MimeMessage(session);
			msg.setText(text);
			msg.setSubject(subject);
			Multipart multipart = new MimeMultipart();
			
			
			BodyPart messageBodyPart1 = new MimeBodyPart();
			String body_text = "Please find the below message \n\n\nMethod Name : " + name + "\n\nReason for failing : "
					+ err;
			messageBodyPart1.setText(body_text);
			multipart.addBodyPart(messageBodyPart1);
			msg.setContent(multipart);
			msg.setFrom(new InternetAddress(userName));
			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
			}
			for (int i = 0; i < cc.length; i++) {
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
			}
			for (int i = 0; i < bcc.length; i++) {
				msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i]));
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

}
