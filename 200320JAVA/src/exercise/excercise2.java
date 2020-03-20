package exercise;

import java.util.Scanner;

public class excercise2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member member;
		System.out.println("이름을 입력하세요.");
		String name = sc.next();
		System.out.println("주소를 입력하세요.");
		String address = sc.next();
		System.out.println("직업을 입력하세요.");
		String job = sc.next();
		System.out.println("나이를 입력하세요.");
		int age = sc.nextInt();
		
		member = new Member(name, address, job, age);
		
		member.showInfo();
	}
}
