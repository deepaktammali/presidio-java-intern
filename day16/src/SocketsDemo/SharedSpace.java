package SocketsDemo;

import java.util.concurrent.LinkedBlockingQueue;

public class SharedSpace {
	
	private LinkedBlockingQueue<String> messagesQueue;
	private int CAPACITY;
	private int consumerCount=0;
	
	public SharedSpace(int CAPACITY) {
		messagesQueue = new LinkedBlockingQueue<String>();
	}
	
	synchronized public void addMessage(String message) {
		messagesQueue.add(message);
	}
	
	public void getMessage(int index) {
		if(messagesQueue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
