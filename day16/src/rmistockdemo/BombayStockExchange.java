package rmistockdemo;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;

public class BombayStockExchange extends UnicastRemoteObject implements StockExchange {

	protected BombayStockExchange() throws RemoteException {
		super();
	}

	@Override
	public double getStockPrice(String stock) throws RemoteException{
		if(stock=="CODA") {
			return 100;
		}
		else {
			return 50;
		}
	}
	
	public static void main(String[] args) throws RemoteException {
		
		BombayStockExchange bombayStockExchange = new BombayStockExchange();
		
		Registry registry = LocateRegistry.createRegistry(2000);
		try {
			registry.bind("bombaystock", bombayStockExchange);
			System.out.println("Bound");
		}
		catch(AlreadyBoundException e) {
			e.printStackTrace();
			System.out.println("Binding Failed");
		}
	}

}
