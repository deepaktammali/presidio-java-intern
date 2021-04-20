package model.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.*;

import model.ItemDataModel;
import model.UserModel;
import util.HibernateUtil;

public class HibernateItemService {

	public static ItemDataModel findById(int id) {
		ItemDataModel item = null;
		try {
			Session session = HibernateUtil.getSession();
			item = findById(id);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return item;
	}

	public static ItemDataModel findByName(String name) {
		ItemDataModel item = null;
		try {
			Session session = HibernateUtil.getSession();
			item = findByName(name);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return item;
	}

	public static List<ItemDataModel> findAll() {
		List<ItemDataModel> items = null;
		try {
			Session session = HibernateUtil.getSession();
			items = findAll(session);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return items;
	}

	public static ItemDataModel insert(ItemDataModel item) {
		try {
			Session session = HibernateUtil.getSession();
			item = insert(session,item);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return item;
	}

	public static ItemDataModel update(ItemDataModel item) throws Exception {
		try {
			Session session = HibernateUtil.getSession();
			item = update(session, item);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return item;
	}

	public static void deleteById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			deleteById(session,id);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
	}

	public static void deleteByName(String name) {
		try {
			Session session = HibernateUtil.getSession();
			deleteByName(session,name);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
	}
	
//	functions with session param

	private static ItemDataModel findById(Session session, int id) {
		ItemDataModel item = null;
		Query<ItemDataModel> query = session.createQuery("from Item i " + "where i.id=:id", ItemDataModel.class);
		query.setParameter("id", id);
		item = query.uniqueResult();
		return item;
	}

	private static ItemDataModel findByName(Session session, String name) {
		ItemDataModel item = null;
		Query<ItemDataModel> query = session.createQuery("from Item i " + "where i.name:name", ItemDataModel.class);
		query.setParameter("name", name);
		item = query.uniqueResult();
		return item;
	}

	private static List<ItemDataModel> findAll(Session session) {
		List<ItemDataModel> items = null;
		items = session.createQuery("from Item", ItemDataModel.class).list();
		return items;
	}

	private static ItemDataModel insert(Session session, ItemDataModel item) {
		session.save(item);
		return item;
	}

	public static ItemDataModel update(Session session, ItemDataModel item) throws Exception {
		ItemDataModel queryItem;
		if (item.getId() != null) {
			queryItem = findById(session, item.getId());
		} else {
			queryItem = findByName(session, item.getName());
		}

		if (queryItem == null) {
			throw new Exception("User doesnot exist");
		}

		queryItem.setName(item.getName());
		queryItem.setDescription(item.getDescription());
		queryItem.setPrice(item.getPrice());
		return queryItem;
	}

	private static void deleteById(Session session, int id) {
		ItemDataModel item = findById(id);
		if (item != null) {
			session.delete(item);
		}
	}

	private static void deleteByName(Session session, String name) {

		ItemDataModel item = findByName(name);
		if (item != null) {
			session.delete(item);
		}
	}

}
