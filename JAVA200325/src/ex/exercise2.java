package ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class exercise2 {
	public static void main(String[] args) {
		HashMap<String, book> book = new HashMap<String, book>();
		
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
		sc.close();
		
		book.put(book_info.name,book_info);
		book books = null;
		Set<String> keys = book.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String name = (String) it.next();
			books = book.get(name);
			System.out.println(books.name+"�� ���ڴ� "+books.author+"�̰� ���ǻ�� "+books.publisher+"�̰� ������ "+books.price+"�̴�.");
		}

	}
}
