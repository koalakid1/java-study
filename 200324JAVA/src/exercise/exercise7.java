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
			
			System.out.println("아이디에 " + id.charAt(a)+"가 포함되면 안됩니다.");
			
		}
		if (b!=-1) {
			
			System.out.println("아이디에 " + id.charAt(b)+"가 포함되면 안됩니다.");
			
		}
		if (c!=-1) {
			
			System.out.println("아이디에 " + id.charAt(c)+"가 포함되면 안됩니다.");
			
		}
		if (d!=-1) {
			
			System.out.println("아이디에 " + id.charAt(d)+"가 포함되면 안됩니다.");
			
		}
		if (e!=-1) {
			
			System.out.println("아이디에 " + id.charAt(e)+"가 포함되면 안됩니다.");
			
		}
		if (f!=-1) {
			
			System.out.println("아이디에 " + id.charAt(f)+"가 포함되면 안됩니다.");
			
		}
		
	}
}
