package model.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.*;

import model.Item;
import model.User;
import util.HibernateUtil;

public class HibernateItemService {

	public static Item findById(int id) {
		Item item = null;
		try {
			Session session = HibernateUtil.getSession();
			item = findById(session, id);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return item;
	}

	public static Item findByName(String name) {
		Item item = null;
		try {
			Session session = HibernateUtil.getSession();
			item = findByName(session, name);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return item;
	}

	public static List<Item> findAll() {
		List<Item> items = null;
		try {
			Session session = HibernateUtil.getSession();
			items = findAll(session);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return items;
	}

	public static Item insert(Item item) {
		try {
			Session session = HibernateUtil.getSession();
			item = insert(session, item);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return item;
	}

	public static Item update(Item item) throws Exception {
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
			deleteById(session, id);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
	}

	public static void deleteByName(String name) {
		try {
			Session session = HibernateUtil.getSession();
			deleteByName(session, name);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
	}

//	functions with session param

	private static Item findById(Session session, int id) {
		Item item = null;
		Query<Item> query = session.createQuery("from Item i " + "where i.id=:id", Item.class);
		query.setParameter("id", id);
		item = query.uniqueResult();
		return item;
	}

	private static Item findByName(Session session, String name) {
		Item item = null;
		Query<Item> query = session.createQuery("from Item i " + "where i.name:name", Item.class);
		query.setParameter("name", name);
		item = query.uniqueResult();
		return item;
	}

	private static List<Item> findAll(Session session) {
		List<Item> items = null;
		items = session.createQuery("from Item", Item.class).list();
		return items;
	}

	private static Item insert(Session session, Item item) {
		session.save(item);
		return item;
	}

	public static Item update(Session session, Item item) throws Exception {
		Item queryItem;
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
		Item item = findById(id);
		if (item != null) {
			session.delete(item);
		}
	}

	private static void deleteByName(Session session, String name) {

		Item item = findByName(name);
		if (item != null) {
			session.delete(item);
		}
	}

}
