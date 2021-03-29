package SocketsDemo;

import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class Client {
	Socket s;

	public Client() throws IOException {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		s = new Socket("localhost", 3000);
		System.out.println("Client Ready");

		while (true) {

			try (PrintStream messageWriter = new PrintStream(s.getOutputStream());
					BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
					BufferedReader messageReader = new BufferedReader(new InputStreamReader(s.getInputStream()));) {

				while (true) {
					if (messageReader.ready()) {
						String message = messageReader.readLine();
						System.out.printf("Server : %s", message).println();
					}

					if (userInputReader.ready()) {
						String message = userInputReader.readLine();
						messageWriter.println(message);
					}

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws IOException {
		new Client();
	}
}
