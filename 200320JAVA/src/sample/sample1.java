package sample;

import java.util.Scanner;

/**
 * @author USER28
 *
 */
public class sample1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int dividend;
		int divisor;
		
		System.out.println("�������� �Է��ϼ���.");
		dividend = sc.nextInt();
		System.out.println("�������� �Է��ϼ���.");
		divisor = sc.nextInt();
		System.out.println(dividend + "�� "+ divisor + "�� ������ ���� " + dividend/divisor+"�Դϴ�.");
		sc.close();	
		
	}
}	
