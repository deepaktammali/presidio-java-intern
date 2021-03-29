package rmiquiz;

import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Vector;
import java.rmi.*;
import java.rmi.registry.*;

public class CollectionsQuiz extends UnicastRemoteObject implements Quiz {

	private Vector<MCQ> questions ;
	private double score;
	
	public CollectionsQuiz() throws RemoteException {
		super();
		this.questions = new Vector<MCQ>();
		questions.add(new MCQ("1. Which of these packages contain all the collection classes?\r\n"
				+ "a) java.lang\r\n"
				+ "b) java.util\r\n"
				+ "c) java.net\r\n"
				+ "d) java.awt","b"));
		
		questions.add(new MCQ("2. Which of these classes is not part of Java’s collection framework?\r\n"
				+ "a) Maps\r\n"
				+ "b) Array\r\n"
				+ "c) Stack\r\n"
				+ "d) Queue","a"));
		
		questions.add(new MCQ("3. Which of these methods deletes all the elements from invoking collection?\r\n"
				+ "a) clear()\r\n"
				+ "b) reset()\r\n"
				+ "c) delete()\r\n"
				+ "d) refresh()","a"));

	}
	
	@Override
	public String getQuestion(int index) {
		if(index<questions.size()) {
			return questions.get(index).getQuestion();
		}
		return ("Quiz Ended. Your Score : "+getScore());
	}

	
	
	@Override
	public double getScore() {
		return score;
	}

	@Override
	public void submitAnswer(String option,int index) {
		if(index>questions.size()) {
			System.out.println("Not a valid request.");
			return;
		}
		String correctAnswer = questions.get(index).getAnswer();
		if(correctAnswer.equalsIgnoreCase(option)) {
			System.out.println("Correct Answer +1");
			this.score+=1;
		}
		else {
			System.out.println("Wrong Answer +0");
		}
	}

	
	public static void main(String[] args) {
		try {
			CollectionsQuiz collectionsQuiz = new CollectionsQuiz();
			Registry registry = LocateRegistry.createRegistry(2000);
			registry.bind("collections_quiz", collectionsQuiz);
			System.out.println("Bound");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	public int getNumberOfQuestions() {
		return questions.size();
	}
	
	
}
