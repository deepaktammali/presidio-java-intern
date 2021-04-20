package model.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.*;

import model.UserModel;
import util.HibernateUtil;

public class HibernateUserService {

	public static UserModel findById(int id) {
		UserModel user = null;
		try {
			Session session = HibernateUtil.getSession();
			user = findById(session,id);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return user;
	}

	public static UserModel findByUserName(String username) {
		UserModel user = null;
		try {
			Session session = HibernateUtil.getSession();
			user = findByUserName(session,username);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return user;
	}

	public static List<UserModel> findAll() {
		List<UserModel> users = null;
		try {
			Session session = HibernateUtil.getSession();
			users = findAll(session);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return users;
	}

	public static UserModel insert(UserModel user) {
		try {
			Session session = HibernateUtil.getSession();
			user = insert(session, user);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return user;
	}

	public static UserModel update(UserModel user) throws Exception {
		try {
			Session session = HibernateUtil.getSession();
			update(session, user);
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

	private static UserModel findById(Session session, int id) {
		UserModel user = null;
		Query<UserModel> query = session.createQuery("from User u " + "where u.id=:id");
		query.setParameter("id", id);
		user = query.uniqueResult();
		return user;
	}

	private static UserModel findByUserName(Session session, String username) {
		UserModel user = null;
		Query<UserModel> query = session.createQuery("from User u " + "where u.username=:username");
		query.setParameter("username", username);
		user = query.uniqueResult();
		return user;
	}

	private static List<UserModel> findAll(Session session) {
		List<UserModel> users = null;
		users = session.createQuery("from User", UserModel.class).list();
		return users;
	}

	private static UserModel insert(Session session, UserModel user) {
		session.save(user);
		return user;
	}

	private static UserModel update(Session session, UserModel user) throws Exception {
		UserModel queryUser;
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

		UserModel user = findById(session, id);
		if (user != null) {
			session.delete(user);
		}

	}

	private static void deleteByUsername(Session session, String username) {
		UserModel user = findByUserName(session, username);
		if (user != null) {
			session.delete(user);
		}
	}

}
