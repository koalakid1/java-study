package ex;

import java.util.ArrayList;
import java.util.Scanner;

class book{
	
	String name, author, publisher;
	int price;
	public book() {
		// TODO Auto-generated constructor stub
	}
}

public class exercise1 {
	public static void main(String[] args) {
		ArrayList<book> book = new ArrayList<book>();
		
		Scanner sc = new Scanner(System.in);
		book book_info = new book();
		System.out.print("å �̸��� �Է��ϼ��� : ");
		book_info.name = sc.next();
		System.out.print("���ڸ� �Է��ϼ��� : ");
		book_info.author = sc.next();
		System.out.print("���ǻ縦 �Է��ϼ��� : ");
		book_info.publisher = sc.next();
		System.out.print("������ �Է��ϼ��� : ");
		book_info.price = sc.nextInt();

		book.add(book_info);
		System.out.println(book.get(0).name+"�� ���ڴ� "+book.get(0).author+"�̰� ���ǻ�� "+book.get(0).publisher+"�̰� ������ "+book.get(0).price+"�̴�.");
		sc.close();
	}
}
