package rmitest;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmistockdemo.StockExchange;

public class StockClient {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry(2000);
			StockExchange stockExchange = (StockExchange)registry.lookup("bombaystock");
			System.out.println("CODA Stock Price : "+stockExchange.getStockPrice("CODA"));;
			System.out.println("Bata Stcok Price : "+stockExchange.getStockPrice("BATA"));;
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
