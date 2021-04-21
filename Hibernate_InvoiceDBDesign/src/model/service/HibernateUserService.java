package model.service;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.*;

import model.User;
import util.HibernateUtil;

public class HibernateUserService {

	public static User findById(int id) {
		User user = null;
		try {
			Session session = HibernateUtil.getSession();
			user = findById(session,id);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return user;
	}

	public static User findByUserName(String username) {
		User user = null;
		try {
			Session session = HibernateUtil.getSession();
			user = findByUserName(session,username);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return user;
	}

	public static List<User> findAll() {
		List<User> users = null;
		try {
			Session session = HibernateUtil.getSession();
			users = findAll(session);
			HibernateUtil.closeSession(null);
			
		} catch (Exception e) {
			System.out.println(e);
			HibernateUtil.closeSession(e);
		}
		return users;
	}

	public static User insert(User user) {
		try {
			Session session = HibernateUtil.getSession();
			user = insert(session, user);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return user;
	}

	public static User update(User user) throws Exception {
		try {
			Session session = HibernateUtil.getSession();
			user = update(session, user);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return user;
	}

	public static void deleteById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			deleteById(session, id);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
	}

	public static void deleteByUsername(String username) {
		try {
			Session session = HibernateUtil.getSession();
			deleteByUsername(session, username);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
	}

//	functions with session param

	private static User findById(Session session, int id) {
		User user = null;
		Query<User> query = session.createQuery("from User u " + "where u.id=:id",User.class);
		query.setParameter("id", id);
		user = query.uniqueResult();
		return user;
	}

	private static User findByUserName(Session session, String username) {
		User user = null;
		Query<User> query = session.createQuery("from User u " + "where u.username=:username",User.class);
		query.setParameter("username", username);
		user = query.uniqueResult();
		return user;
	}

	private static List<User> findAll(Session session) {
		List<User> users = null;
		users = session.createQuery("from User", User.class).list();
		return users;
	}

	private static User insert(Session session, User user) {
		session.save(user);
		return user;
	}

	private static User update(Session session, User user) throws Exception {
		
		User queryUser=null;
		if (user.getId() != null) {
			queryUser = findById(session, user.getId());
		} else {
			queryUser = findByUserName(session, user.getUsername());
		}

		if (queryUser == null) {
			throw new Exception("User doesnot exist");
		}
		
		queryUser.setUsername(user.getUsername());
		queryUser.setPassword(user.getPassword());
		queryUser.setFlag(user.getFlag());
		return queryUser;
	}

	private static void deleteById(Session session, int id) {

		User user = findById(session, id);
		if (user != null) {
			session.delete(user);
		}

	}

	private static void deleteByUsername(Session session, String username) {
		User user = findByUserName(session, username);
		if (user != null) {
			session.delete(user);
		}
	}

}
