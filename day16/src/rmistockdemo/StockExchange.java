package rmistockdemo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockExchange extends Remote {
	public double getStockPrice(String stock) throws RemoteException;
}
