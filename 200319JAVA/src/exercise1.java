import java.util.Scanner;

public class exercise1{
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("exit�� �Է��ϸ� �����մϴ�.");
	
		String text;
		do {
			System.out.print(">>");
			text = sc.nextLine();
		} while (!text.equals("exit"));
		System.out.println("�����մϴ�...");
	}
}