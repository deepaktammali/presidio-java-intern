package model.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Customer;
import util.HibernateUtil;

public class HibernateCustomerService {

	public static Customer findById(int id) {
		Customer customer = null;
		try {
			Session session = HibernateUtil.getSession();
			customer = findById(session, id);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return customer;
	}

	public static Customer findByName(String name) {
		Customer customer = null;
		try {
			Session session = HibernateUtil.getSession();
			customer = findByName(session, name);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return customer;
	}

	public static Customer findByMobileNumber(String mobileNumber) {
		Customer customer = null;
		try {
			Session session = HibernateUtil.getSession();
			customer = findByMobileNumber(session, mobileNumber);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return customer;
	}

	public static List<Customer> findAll() {
		List<Customer> customers = null;
		try {
			Session session = HibernateUtil.getSession();
			customers = findAll(session);
			HibernateUtil.closeSession(null);

		} catch (Exception e) {
			System.out.println(e);
			HibernateUtil.closeSession(e);
		}
		return customers;
	}

	public static Customer insert(Customer customer) {
		try {
			Session session = HibernateUtil.getSession();
			customer = insert(session, customer);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return customer;
	}

	public static Customer update(Customer customer) throws Exception {
		try {
			Session session = HibernateUtil.getSession();
			customer = update(session, customer);
			HibernateUtil.closeSession(null);
		} catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
		return customer;
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

//		functions with session param

	private static Customer findById(Session session, int id) {
		Customer customer = null;
		Query<Customer> query = session.createQuery("from Customer c " + "where c.id=:id", Customer.class);
		query.setParameter("id", id);
		customer = query.uniqueResult();
		return customer;
	}

	private static Customer findByName(Session session, String name) {
		Customer customer = null;
		Query<Customer> query = session.createQuery("from Customer c " + "where u.name=:name", Customer.class);
		query.setParameter("name", name);
		customer = query.uniqueResult();
		return customer;
	}

	public static Customer findByMobileNumber(Session session, String mobileNumber) {
		Customer customer = null;
		Query<Customer> query = session.createQuery("from Customer c " + "where u.mobileNumber=:mobileNumber",
				Customer.class);
		query.setParameter("mobileNumber", mobileNumber);
		customer = query.uniqueResult();
		return customer;
	}

	private static List<Customer> findAll(Session session) {
		List<Customer> customers = null;
		customers = session.createQuery("from Customer", Customer.class).list();
		return customers;
	}

	private static Customer insert(Session session, Customer customer) {
		session.save(customer);
		return customer;
	}

	private static Customer update(Session session, Customer customer) throws Exception {
		Customer queryCustomer = findById(session, customer.getId());

		if (queryCustomer == null) {
			throw new Exception("User doesnot exist");
		}

		queryCustomer.setAddress(customer.getAddress());
		queryCustomer.setMobileNumber(customer.getMobileNumber());
		queryCustomer.setName(customer.getName());
		return queryCustomer;
	}

	private static void deleteById(Session session, int id) {

		Customer customer = findById(session, id);
		if (customer != null) {
			session.delete(customer);
		}
	}

}
