package ex;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ex1 {
	public static void main(String[] args) {
		
		
		FileWriter fo = null;
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			
			try {
				Date d = new Date();
				String today = (new SimpleDateFormat("yyyyMMddHHmmss").format(d));
				fo = new FileWriter("c:\\temp\\"+today + ".log");
				fo.write("������ �߻��߽��ϴ�.",0,11);
				fo.flush();// TODO: handle exception
			} catch (IOException e2) {
				System.out.println("dd");// TODO: handle exception
			}	
		}
		
	}
}
