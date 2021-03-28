package javaio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;


public class Streams {
	public static void main(String[] args) throws IOException {
		String packagePath = Path.of(System.getProperty("user.dir"),"src",Streams.class.getPackageName()).toString();
		String inputFileName = "input.txt";
		String outputFileName = "output.txt";
	
		FileInputStream fileInputStream = new FileInputStream(Path.of(packagePath,inputFileName).toString());
		FileOutputStream fileOutputStream = new FileOutputStream(Path.of(packagePath,outputFileName).toString());
		
//		reading one byte at a time using FileInputStream
		int data;
		data = fileInputStream.read();
		
		while(data!=-1) {
			System.out.print((char)data);
			fileOutputStream.write(data); //writing one int at a time to output file
			data = fileInputStream.read();
		}
		
		
		
		fileInputStream.close();
		fileOutputStream.close();
	}
}
