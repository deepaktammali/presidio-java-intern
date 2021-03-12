package labtest2solutions;

import java.util.Scanner;

public class Q4IntegerStack {
	
	public static void main(String[] args) {
		Scanner sc         = new Scanner(System.in);
		int size           = sc.nextInt();
		sc.close();
		Stack integerStack = new Stack(size);
		integerStack.pushElement(9);
		integerStack.pushElement(2);
		integerStack.pushElement(5);
		integerStack.printStack();
		integerStack.popElement(5);
		integerStack.printStack();
	}

}


class Stack{
	
	private int[] stack;
	private int top;
	private int size;
	
	Stack(int size){
		this.size = size;
		stack = new int[size];
	}
	
	public void printStack() {
		if(top==0) {
			System.out.println("Stack is empty!");
		}
		else {
			for(int i=(top-1);i>=0;i--) {
				System.out.println(this.stack[i]);
			}
		}
	}
	
	public void pushElement(int element) {
		if(top>(this.size-1)) {
			System.out.println("Cannot push element!");
		}
		else {
			this.stack[top] = element;
			top+=1;
			
		}
	}
	
	public void popElement(int element) {
		if(top>0) {
			top-=1;
			System.out.println("Removed "+this.stack[top]);
		}
		else {
			System.out.println("Stack already empty!");
		}
	}

}









