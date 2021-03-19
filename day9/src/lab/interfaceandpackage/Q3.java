package lab.interfaceandpackage;

import java.util.Arrays;

public class Q3 {
	public static void main(String[] args) {
		FixedStack fixedStack = new FixedStack(5);
		DynamicStack dynamicStack = new DynamicStack(5);
		
		System.out.println("Fixed Stack pushing 10 elements");
		for (int i=0;i<10;i++) {
			fixedStack.push(i);
		}
		System.out.print("Fixed Stack : ");
		fixedStack.display();
		
		System.out.println("Dynamic Stack pushing 10 elements");
		for (int i=0;i<10;i++) {
			dynamicStack.push(i);
		}
		System.out.print("Dynamic Stack : ");
		dynamicStack.display();
		
	}
}

interface Stack{
	public void push(int element);
	public void pop();
	public void display();
}

class FixedStack implements Stack{
	
	private final int SIZE;
	private int[] stack;
	private int currPos=0;
	
	public FixedStack(int SIZE) {
		this.SIZE=SIZE;
		stack = new int[SIZE];
		
	}
	
	@Override
	public void push(int element) {
		if(currPos<SIZE) {
			stack[currPos] = element;
			currPos+=1;
		}
		else {
			System.out.println("Cannot Push.Stack FULL.");
		}
	}

	@Override
	public void pop() {
		if(currPos>0) {
			System.out.println("POPPED "+stack[currPos-1]);
			currPos-=1;
		}
		else {
			System.out.println("Stack is EMPTY.");
		}
	}

	@Override
	public void display() {
		System.out.println(Arrays.toString(this.stack));
	}
	
}


class DynamicStack implements Stack{
	
	private int SIZE;
	private int[] stack;
	private int currPos=0;
	
	public DynamicStack(int SIZE) {
		this.SIZE = SIZE;
		stack = new int[SIZE];
	}
	
	@Override
	public void push(int element) {
		if(currPos<SIZE) {
			stack[currPos] = element;
			currPos+=1;
		}
		else {
			System.out.println("size limit reached adding 1 slot");
			int temp[] = new int[SIZE];
			System.arraycopy(stack, 0, temp, 0, SIZE);
			stack = new int[SIZE+1];
			System.arraycopy(temp, 0, stack, 0, SIZE);
			SIZE+=1;
			stack[currPos] = element;
			currPos+=1;
		}
		
	}

	@Override
	public void pop() {
		if(currPos>0) {
			System.out.println("POPPED "+stack[currPos-1]);
			currPos-=1;
		}
		else {
			System.out.println("Stack is EMPTY.");
		}
	}

	@Override
	public void display() {
		System.out.println(Arrays.toString(this.stack));
	}
	
	
}