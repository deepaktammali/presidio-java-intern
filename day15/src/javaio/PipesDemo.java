package javaio;

import java.io.*;

public class PipesDemo {
	
	public static void main(String[] args) throws IOException {
		
		PipedOutputStream output = new PipedOutputStream();
		PipedInputStream input = new PipedInputStream(output);
		
		Thread outputThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					output.write("From the outputThread".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		Thread inputThread = new Thread(new Runnable() {

			@Override
			public void run(){
				int data = -1;
				try {
					data = input.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(data!=-1) {
					System.out.println((char)data);
					try {
						data = input.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
				
			
		});
		
		outputThread.start();
		inputThread.start();
	}
}

