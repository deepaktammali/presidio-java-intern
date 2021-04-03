package datamodel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import datamodel.baseclass.InvoiceDataModel;
import datamodel.baseclass.UserModel;
import utils.DatabaseUtils;

public class Invoice extends InvoiceDataModel {

	static {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		try(Statement dbStatement = databaseConnection.createStatement();){
			dbStatement.execute("CREATE TABLE invoices("
					+ "invoiceId INT PRIMARY KEY NOT NULL,"
					+ "customerId INT NOT_NULL,"
					+ "invoiceDate VARCHAR(20));");
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
	}
	
	public Invoice(int invoiceId, int customerId, String invoiceDate) {
		super(invoiceId, customerId, invoiceDate);
	}
	
	public InvoiceDataModel findByID(Integer invoiceId) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		InvoiceDataModel queryInvoice = null;
		try(Statement dbStatement = databaseConnection.createStatement();){
			ResultSet invoices = dbStatement.executeQuery("SELECT * FROM invoices WHERE invoiceId="+invoiceId+";");
			
			if(invoices.next()) {
				int customerId = invoices.getInt("customerId");
				String invoiceDate = invoices.getString("invoiceDate");
				queryInvoice = new InvoiceDataModel(invoiceId, customerId, invoiceDate);
			}
			
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return queryInvoice;
		
	}
	public List<InvoiceDataModel> findAll(){
		ArrayList<InvoiceDataModel> queryInvoices = new ArrayList<>();
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		try(Statement dbStatement = databaseConnection.createStatement();){
			ResultSet invoices = dbStatement.executeQuery("SELECT * FROM invoices;");
			
			while(invoices.next()) {
				int invoiceId = invoices.getInt("invoiceId");
				int customerId = invoices.getInt("customerId");
				String invoiceDate = invoices.getString("invoiceDate");
				queryInvoices.add(new InvoiceDataModel(invoiceId, customerId, invoiceDate));
			}
			
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return queryInvoices;
	};
	

	public int insertInvoice(InvoiceDataModel invoice) {
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		int i = 0;
		try (Statement dbStatement = databaseConnection.createStatement();) {
			i = dbStatement.executeUpdate("INSERT INTO invoices(invoiceId,customerId,invoiceDate) VALUES(" + invoice.getInvoiceId() + ","
					+ invoice.getCustomerId() + "," + invoice.getInvoiceDate() + ");");
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		return i;
	};
	

	public int updateInvoice(InvoiceDataModel invoice) {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		try (Statement dbStatement = databaseConnection.createStatement();) {
			i = dbStatement.executeUpdate("UPDATE invoices" + "SET customerId=" + invoice.getCustomerId() + ",invoiceDate="
					+ invoice.getInvoiceDate() + "" + "WHERE invoiceId=" + invoice.getInvoiceId() + ";");
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		
		return i;
	};
	
	
	public int deleteInvoiceById(Integer invoiceId) {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		try (Statement dbStatement = databaseConnection.createStatement();) {
			i = dbStatement.executeUpdate("DELETE FROM invoices" + "WHERE invoiceId=" + invoiceId + ";");
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		
		return i;
	};
	
	public int deleteInvoiceByCustomerId(Integer customerId) {
		int i = 0;
		Connection databaseConnection = DatabaseUtils.getDatabaseConnection();
		try (Statement dbStatement = databaseConnection.createStatement();) {
			i = dbStatement.executeUpdate("DELETE FROM invoices" + "WHERE customerId=" + customerId + ";");
			DatabaseUtils.close();
		} catch (SQLException e) {
			DatabaseUtils.close(e);
			e.printStackTrace();
		}
		
		return i;
	};
	
	public int deleteInvoice(InvoiceDataModel invoice) {
		return deleteInvoiceById(invoice.getInvoiceId());
	};
	
}
