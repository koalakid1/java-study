package fex;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ex2 {
	
	public static void main(String[] args) {
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("c:\\Temp\\test.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out,5);
			while ((c = fin.read()) != -1) {
				out.write(c);
			}
			
			new Scanner(System.in).nextLine();
			out.flush();
			fin.close();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
}
