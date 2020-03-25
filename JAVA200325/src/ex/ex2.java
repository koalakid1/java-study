package ex;

import java.io.FileReader;
import java.io.IOException;

public class ex2 {
	public static void main(String[] args) {
		FileReader fin = null;
		
		try {
			
			fin = new FileReader("c:\\windwos\\system.ini");
			int c;
			while ((c=fin.read())!=-1) {
				System.out.println((char)c);
			}
			fin.close();
			
		} catch (IOException e) {
			System.out.println("입출력 오류");// TODO: handle exception
		}
		
	}
}
