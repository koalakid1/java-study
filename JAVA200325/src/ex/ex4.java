package ex;

import java.util.Scanner;

public class ex4 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		int b = 2*a -1;
		
		for (int i = 1; i <= a; i++) {
			int c = 2*i -1;
			for (int j = 0; j < (b-c)/2; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < c; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < (b-c)/2; j++) {
				System.out.print(" ");
			}
			System.out.println("");
		}
		
	}
}
