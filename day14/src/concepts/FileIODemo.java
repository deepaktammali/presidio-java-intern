package concepts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIODemo {
	public static void main(String[] args) throws IOException {
//		final String pathUrl = "C:\\Users\\VC\\Desktop\\Presidio_Intern\\JavaFullStack\\day14\\src\\concepts\\";
//		FileInputStream fileInputStream = new FileInputStream(pathUrl+"package.properties");
//		FileOutputStream fileOutputStream = new FileOutputStream(pathUrl+"package.txt");
//		
////		int i;   i contains the ASCII value of the character reads one char at a time
////		while ((i = fileInputStream.read()) != -1) {
////			System.out.print((char) i);
////		}
//		
//		byte b[] = new byte[20];
//		int i ;
//		while((i=fileInputStream.read(b))!=-1) {
//			System.out.println("Bytes read : "+i);
//			System.out.println(new String(b,0,i));
//			fileOutputStream.write(b,0,i);
//		}
//		
//		fileOutputStream.close();
//		fileInputStream.close();

//		Instead of closing using try with resources

		final String pathUrl = "C:\\Users\\VC\\Desktop\\Presidio_Intern\\JavaFullStack\\day14\\src\\concepts\\";
		try (FileInputStream fileInputStream = new FileInputStream(pathUrl + "package.properties");
				FileOutputStream fileOutputStream = new FileOutputStream(pathUrl + "package.txt");) {

			byte b[] = new byte[20];
			int i;
			while ((i = fileInputStream.read(b)) != -1) {
				System.out.println("Bytes read : " + i);
				System.out.println(new String(b, 0, i));
				fileOutputStream.write(b, 0, i);

			}

		}

	}
}
