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
		
		System.out.println("나뉨수를 입력하세요.");
		dividend = sc.nextInt();
		System.out.println("나눗수를 입력하세요.");
		divisor = sc.nextInt();
		System.out.println(dividend + "를 "+ divisor + "로 나누면 몫은 " + dividend/divisor+"입니다.");
		sc.close();	
		
	}
}	
