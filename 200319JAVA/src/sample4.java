import java.util.Scanner;

public class sample4 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("exit�� �Է��ϸ� �����մϴ�.");
		while (true) {
			
			System.out.print(">>");
			String text = sc.nextLine();
			if (text.equals("exit")) {
				
				break;
				
			}
			
		}
		
		System.out.println("�����մϴ�.");
		
		sc.close();
		
	}
}