package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static ThreadLocal<Session> sessionLocal;
	private static SessionFactory sessionFactory;
	static {
		sessionLocal = new ThreadLocal<>();
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() 
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			System.out.println(e);
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	private HibernateUtil() {
		
	}
	
	public static Session getSession() {
		if((sessionLocal.get())==null) {
			Session newSession = sessionFactory.openSession();
			sessionLocal.set(newSession);
		}
		Session session = sessionLocal.get();
		session.getTransaction().begin();
		return session;
	}
	
	public static void closeSession(Exception e) {
		Session session = sessionLocal.get();
		if(session==null) {
			return ;
		}
		Transaction transaction = session.getTransaction();
		if(e!=null) {
			transaction.rollback();
		}
		else {
			transaction.commit();
		}
		session.close();
		sessionLocal.remove();
	}
	
}
