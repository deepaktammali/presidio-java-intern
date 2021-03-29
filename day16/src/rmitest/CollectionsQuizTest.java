package rmitest;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.Scanner;

import rmiquiz.Quiz;

public class CollectionsQuizTest {
	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
		try {
			Registry registry = LocateRegistry.getRegistry(2000);
			Quiz collectionsQuiz = (Quiz)registry.lookup("collections_quiz");
			
			for(int index=0;index<collectionsQuiz.getNumberOfQuestions();index++) {
				System.out.println(collectionsQuiz.getQuestion(index));
				String answer = userInput.next();
				collectionsQuiz.submitAnswer(answer,index);
			}
			
			System.out.println("You Scored : "+collectionsQuiz.getScore());;
			
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
