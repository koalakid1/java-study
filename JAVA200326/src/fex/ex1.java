package fex;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FileWriter fout = null;
		
		int c;
		try {
			fout = new FileWriter("c:\\temp\\test.txt");
			while (true) {
				String line = sc.nextLine();
				if (line.length() == 0) {
					break;
				}
				fout.write(line,0,line.length());
				fout.write("\r\n",0,2);
			}
			fout.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");// TODO: handle exception
		}
		sc.close();
		
	}
}
