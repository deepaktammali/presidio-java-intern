package SocketsDemo;

import java.net.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public class Server {
	ServerSocket server;
	Socket clientSocket;

	public Server() throws IOException {
		server = new ServerSocket(3000);
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
//		BlockingStringArray messagesArray = new BlockingStringArray(10);
		ArrayBlockingQueue<String> messagesArray = new ArrayBlockingQueue<String>(20);
		System.out.println("Server Ready");

		fixedThreadPool.execute(new Runnable() {

			@Override
			public void run() {

				try (BufferedReader serverInputReader = new BufferedReader(new InputStreamReader(System.in));) {

					if (serverInputReader.ready()) {
						String message = serverInputReader.readLine();
						if (!message.equals("")) {
							messagesArray.put(message);
						}
					}

				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}

			}

		});

		while (true) {
			clientSocket = server.accept();
			
			fixedThreadPool.execute(new Runnable() {

				@Override
				public void run() {
					int clientId = (new Random()).nextInt(100);
					try (BufferedReader clientMessageReader = new BufferedReader(
							new InputStreamReader(clientSocket.getInputStream()));
						PrintStream clientMessageWriter = new PrintStream(clientSocket.getOutputStream());
							) {

						while (true) {
							
							
							if (clientMessageReader.ready()) {
								String message = clientMessageReader.readLine();
								System.out.printf("Client %d : %s", clientId, message).println();
							}
						}

					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			});
			

		}

	}

	public static void main(String[] args) throws IOException {
		new Server();
	}
}
