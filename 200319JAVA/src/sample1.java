import java.util.Scanner;

public class sample1{
	
	public static void main(String[] args) {
		
		char grade;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ���(0~100): ");
		int score = sc.nextInt();
		if (score >= 90)
			grade = 'A';
		else if (score >= 80)
			grade = 'B';
		else if (score >= 70)
			grade = 'C';
		else if (score >= 60)
			grade = 'D';
		else
			grade = 'E';
		
		System.out.println("������ " + grade + "�Դϴ�.");
		
		sc.close();
		
	}
	
}