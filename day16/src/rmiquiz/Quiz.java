package rmiquiz;

import java.rmi.*;
import java.rmi.registry.*;

public interface Quiz extends Remote {
	public String getQuestion(int index) throws RemoteException;
	public void submitAnswer(String option,int index) throws RemoteException;
	public int getNumberOfQuestions() throws RemoteException;
	public double getScore() throws RemoteException;
}
