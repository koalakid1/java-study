package exercise;

import java.util.Scanner;

public class exercise7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		sc.close();
		
		int a = id.indexOf("!");
		int b = id.indexOf("@");
		int c = id.indexOf("#");
		int d = id.indexOf("$");
		int e = id.indexOf("%");
		int f = id.indexOf("^");
		
		if (a!=-1) {
			
			System.out.println("���̵� " + id.charAt(a)+"�� ���ԵǸ� �ȵ˴ϴ�.");
			
		}
		if (b!=-1) {
			
			System.out.println("���̵� " + id.charAt(b)+"�� ���ԵǸ� �ȵ˴ϴ�.");
			
		}
		if (c!=-1) {
			
			System.out.println("���̵� " + id.charAt(c)+"�� ���ԵǸ� �ȵ˴ϴ�.");
			
		}
		if (d!=-1) {
			
			System.out.println("���̵� " + id.charAt(d)+"�� ���ԵǸ� �ȵ˴ϴ�.");
			
		}
		if (e!=-1) {
			
			System.out.println("���̵� " + id.charAt(e)+"�� ���ԵǸ� �ȵ˴ϴ�.");
			
		}
		if (f!=-1) {
			
			System.out.println("���̵� " + id.charAt(f)+"�� ���ԵǸ� �ȵ˴ϴ�.");
			
		}
		
	}
}
