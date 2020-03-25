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
		System.out.print("책 이름을 입력하세요 : ");
		book_info.name = sc.next();
		System.out.print("저자를 입력하세요 : ");
		book_info.author = sc.next();
		System.out.print("출판사를 입력하세요 : ");
		book_info.publisher = sc.next();
		System.out.print("가격을 입력하세요 : ");
		book_info.price = sc.nextInt();

		book.add(book_info);
		System.out.println(book.get(0).name+"의 저자는 "+book.get(0).author+"이고 출판사는 "+book.get(0).publisher+"이고 가격은 "+book.get(0).price+"이다.");
		sc.close();
	}
}
