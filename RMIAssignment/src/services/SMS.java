package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import services.remoteinterfaces.SMSService;

public class SMS implements SMSService{
public static void main(String[] args) {
		
		try(
				FileInputStream smsEnvFileInputStream = new FileInputStream("smsenv.properties");
				)
		{
			Properties smsEnvProperties = new Properties();
			
			smsEnvProperties.load(smsEnvFileInputStream);
			
			final String ACCOUNT_SID = smsEnvProperties.getProperty("ACCOUNT_SID");
		    final String AUTH_TOKEN = smsEnvProperties.getProperty("AUTH_TOKEN");
		    final String FROM_NUMBER = smsEnvProperties.getProperty("FROM_NUMBER");
		    
		        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		        Message message = Message
		                .creator(new PhoneNumber("+919500822273"), // to
		                        new PhoneNumber(FROM_NUMBER), // from
		                        "Sent Using Twilio?")
		                .create();

		        System.out.println(message.getSid());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
