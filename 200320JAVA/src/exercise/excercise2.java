package exercise;

import java.util.Scanner;

public class excercise2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member member;
		System.out.println("�̸��� �Է��ϼ���.");
		String name = sc.next();
		System.out.println("�ּҸ� �Է��ϼ���.");
		String address = sc.next();
		System.out.println("������ �Է��ϼ���.");
		String job = sc.next();
		System.out.println("���̸� �Է��ϼ���.");
		int age = sc.nextInt();
		
		member = new Member(name, address, job, age);
		
		member.showInfo();
	}
}
