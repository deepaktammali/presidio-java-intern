package lab;

import java.util.PriorityQueue;

// B. 2 2 3 4

public class Q10 {
	public static void main(String[] args) {
		PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
		priorityQueue.add("2");
		priorityQueue.add("4");

		System.out.print(priorityQueue.peek() + " ");

		priorityQueue.offer("1");
		priorityQueue.add("3");
		priorityQueue.remove("1");

		System.out.print(priorityQueue.poll() + " ");

		if (priorityQueue.remove("2"))
			System.out.print(priorityQueue.poll() + " ");
		
		System.out.println(priorityQueue.poll() + " " + priorityQueue.peek());
	}
}
