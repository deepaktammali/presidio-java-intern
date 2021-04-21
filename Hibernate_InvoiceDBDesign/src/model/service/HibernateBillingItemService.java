package model.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.BillingItem;
import model.Item;
import model.User;
import util.HibernateUtil;

public class HibernateBillingItemService {

	public static BillingItem find(Integer invoiceId, Integer itemId) {
		BillingItem billingItem = null;
		try {
			Session session = HibernateUtil.getSession();
			billingItem = find(session, invoiceId,itemId);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return billingItem;
	}

	public static List<BillingItem> findByInvoiceId(Integer id) {
		List<BillingItem> billingItems = null;
		try {
			Session session = HibernateUtil.getSession();
			billingItems = findByInvoiceId(session, id);
			HibernateUtil.closeSession(null);

		} catch (Exception e) {
			System.out.println(e);
			HibernateUtil.closeSession(e);
		}
		return billingItems;
	}

	public static List<BillingItem> findByItemId(Integer id) {
		List<BillingItem> billingItems = null;
		try {
			Session session = HibernateUtil.getSession();
			billingItems = findByItemId(session, id);
			HibernateUtil.closeSession(null);

		} catch (Exception e) {
			System.out.println(e);
			HibernateUtil.closeSession(e);
		}
		return billingItems;
	}

	public static List<BillingItem> findAll() {
		List<BillingItem> billingItems = null;
		try {
			Session session = HibernateUtil.getSession();
			billingItems = findAll(session);
			HibernateUtil.closeSession(null);

		} catch (Exception e) {
			System.out.println(e);
			HibernateUtil.closeSession(e);
		}
		return billingItems;
	}

	public static BillingItem insert(BillingItem billingItem) {
		try {
			Session session = HibernateUtil.getSession();
			billingItem = insert(session, billingItem);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return billingItem;
	}

	public BillingItem update(BillingItem billingItem) {
		try {
			Session session = HibernateUtil.getSession();
			billingItem = update(session, billingItem);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return billingItem;
	}

	public static void delete(int invoiceId,int itemId) {
		try {
			Session session = HibernateUtil.getSession();
			delete(session, invoiceId,itemId);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
	}

	public static void deleteByInvoiceId(int id) {
		try {
			Session session = HibernateUtil.getSession();
			deleteByInvoiceId(session, id);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		
	}
	
	public static void deleteByItemId(int id) {
		try {
			Session session = HibernateUtil.getSession();
			deleteByItemId(session, id);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
	}
	

//	functions with session param

	private static BillingItem find(Session session, Integer invoiceId, Integer itemId) {
		BillingItem billingItem = null;
		Query<model.BillingItem> query = session.createQuery(
				"from BillingItem b " + "where b.invoice_id:invoiceId and " + "b.item_id:itemId", BillingItem.class);
		query.setParameter("invoiceId", invoiceId);
		query.setParameter("itemId", itemId);
		billingItem = query.uniqueResult();
		return billingItem;
	}

	private static List<BillingItem> findByInvoiceId(Session session, Integer id) {
		List<BillingItem> billingItems = null;
		Query<model.BillingItem> query = session.createQuery("from BillingItem b " + "where b.invoice_id:id",
				BillingItem.class);
		query.setParameter("id", id);
		billingItems = query.list();
		return billingItems;
	}

	private static List<BillingItem> findByItemId(Session session, Integer id) {
		List<BillingItem> billingItems = null;
		Query<model.BillingItem> query = session.createQuery("from BillingItem b " + "where b.item_id:id",
				BillingItem.class);
		query.setParameter("id", id);
		billingItems = query.list();
		return billingItems;
	}

	public static List<BillingItem> findAll(Session session) {
		List<BillingItem> billingItems = null;
		billingItems = session.createQuery("from BillingItem", BillingItem.class).list();
		return billingItems;
	};

	private static BillingItem insert(Session session, BillingItem billingItem) {
		session.save(billingItem);
		return billingItem;
	}

	private static BillingItem update(Session session, BillingItem billingItem) throws Exception {

		int invoiceId = billingItem.getInvoice().getId();
		int itemId = billingItem.getItem().getId();
		
		BillingItem queryBillingItem = find(session,invoiceId, itemId);

		if (queryBillingItem == null) {
			throw new Exception("Billing Item doesnot exist");
		}

		queryBillingItem.setQuantity(billingItem.getQuantity());
		return queryBillingItem;
	}
	
	private static void delete(Session session,int invoiceId,int itemId) {
		BillingItem billingItem = find(session,invoiceId,itemId);
		if (billingItem != null) {
			session.delete(billingItem);
		}
	}

	private static void deleteByInvoiceId(Session session,int id) {
		List<BillingItem> billingItems = findByInvoiceId(session,id);
		Iterator<BillingItem> billingItemIterator = billingItems.iterator();
		while(billingItemIterator.hasNext()) {
			session.delete(billingItemIterator.next());
		}
		
	}
	
	private static void deleteByItemId(Session session,int id) {
		List<BillingItem> billingItems = findByItemId(session,id);
		Iterator<BillingItem> billingItemIterator = billingItems.iterator();
		while(billingItemIterator.hasNext()) {
			session.delete(billingItemIterator.next());
		}
	}
	
	
	
}
