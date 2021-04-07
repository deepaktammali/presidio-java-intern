package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.Message.RecipientType;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import services.remoteinterfaces.EmailService;

public class Email implements EmailService {
	
//	
	
	public static void main(String[] args) throws MessagingException {
		
		try(
				FileInputStream mailEnvFileInputStream = new FileInputStream("mailenv.properties");
				)
		{
			String host = "smtp.gmail.com";
			
			Properties mailEnvProperties = new Properties();
			mailEnvProperties.load(mailEnvFileInputStream);
			
			Properties mailConfigProperties = new Properties();
			mailConfigProperties.setProperty("mail.smtp.host",host);
			mailConfigProperties.setProperty("mail.smtp.ssl.enable","true");
			Session session = Session.getInstance(mailConfigProperties);
			
			MimeMessage message = new MimeMessage(session);
			message.setText("Message-2 sent using jakarta mail");
			message.setRecipient(RecipientType.TO,new InternetAddress("121004258@sastra.ac.in"));
			Transport.send(message,mailEnvProperties.getProperty("username"),mailEnvProperties.getProperty("password"));
			
			System.out.println("Mail Sent");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
