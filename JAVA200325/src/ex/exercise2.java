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
		System.out.print("책 이름을 입력하세요 : ");
		book_info.name = sc.next();
		System.out.print("저자를 입력하세요 : ");
		book_info.author = sc.next();
		System.out.print("출판사를 입력하세요 : ");
		book_info.publisher = sc.next();
		System.out.print("가격을 입력하세요 : ");
		book_info.price = sc.nextInt();
		sc.close();
		
		book.put(book_info.name,book_info);
		book books = null;
		Set<String> keys = book.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String name = (String) it.next();
			books = book.get(name);
			System.out.println(books.name+"의 저자는 "+books.author+"이고 출판사는 "+books.publisher+"이고 가격은 "+books.price+"이다.");
		}

	}
}
