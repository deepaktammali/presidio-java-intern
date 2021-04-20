package test;
import java.util.List;

import org.hibernate.Session;

import pojo.Message;
import utils.HibernateUtil;

public class MessageTest {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSession();
			
			Message message = new Message("Hello Hibernate");
			session.persist(message);
			
//			get all messages
			
			List<Message> messages = session.createQuery("from Message",Message.class).list();
			
			for(Message m:messages) {
				System.out.println(m);
			}
			
			HibernateUtil.closeSession(null);
		}
		catch(Exception e) {
			HibernateUtil.closeSession(e);
		}
		
	}
}
