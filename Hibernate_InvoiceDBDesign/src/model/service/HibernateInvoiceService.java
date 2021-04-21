package model.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Invoice;
import util.HibernateUtil;

public class HibernateInvoiceService {


	public static Invoice findByInvoiceId(Integer id) {
		Invoice invoiceItem = null;
		try {
			Session session = HibernateUtil.getSession();
			invoiceItem = findByInvoiceId(session, id);
			HibernateUtil.closeSession(null);

		} catch (Exception e) {
			System.out.println(e);
			HibernateUtil.closeSession(e);
		}
		return invoiceItem;
	}

	public static List<Invoice> findByCustomerId(Integer id) {
		List<Invoice> invoices = null;
		try {
			Session session = HibernateUtil.getSession();
			invoices = findByCustomerId(session, id);
			HibernateUtil.closeSession(null);

		} catch (Exception e) {
			System.out.println(e);
			HibernateUtil.closeSession(e);
		}
		return invoices;
	}

	public static List<Invoice> findAll() {
		List<Invoice> invoices = null;
		try {
			Session session = HibernateUtil.getSession();
			invoices = findAll(session);
			HibernateUtil.closeSession(null);

		} catch (Exception e) {
			System.out.println(e);
			HibernateUtil.closeSession(e);
		}
		return invoices;
	}

	public static Invoice insert(Invoice invoice) {
		try {
			Session session = HibernateUtil.getSession();
			invoice = insert(session, invoice);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return invoice;
	}


	public static void deleteByInvoiceId(int invoiceId) {
		try {
			Session session = HibernateUtil.getSession();
			deleteByInvoiceId(session, invoiceId);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
	}

	public static void deleteByCustomerId(int customerId) {
		try {
			Session session = HibernateUtil.getSession();
			deleteByCustomerId(session, customerId);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
	}

//		functions with session param

	private static Invoice findByInvoiceId(Session session, Integer id) {
		Invoice invoice = null;
		Query<Invoice> query = session.createQuery("from Invoice i " + "where i.invoice_id:id",
				Invoice.class);
		query.setParameter("id", id);
		invoice = query.uniqueResult();
		return invoice;
	}

	private static List<Invoice> findByCustomerId(Session session, Integer id) {
		List<Invoice> invoices = null;
		Query<Invoice> query = session.createQuery("from Invoice i " + "where b.customer_id:id",
				Invoice.class);
		query.setParameter("id", id);
		invoices = query.list();
		return invoices;
	}

	public static List<Invoice> findAll(Session session) {
		List<Invoice> invoices = null;
		invoices = session.createQuery("from Invoice", Invoice.class).list();
		return invoices;
	};

	private static Invoice insert(Session session, Invoice invoice) {
		session.save(invoice);
		return invoice;
	}


	private static void deleteByInvoiceId(Session session, int id) {
		Invoice invoice = findByInvoiceId(session, id);
		if (invoice!=null) {
			session.delete(invoice);
		}
	}

	private static void deleteByCustomerId(Session session, int id) {
		List<Invoice> invoices = findByCustomerId(session, id);
		Iterator<Invoice> invoiceIterator = invoices.iterator();
		while (invoiceIterator.hasNext()) {
			session.delete(invoiceIterator.next());
		}
	}

}
