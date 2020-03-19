import java.util.Scanner;

public class sample1{
	
	public static void main(String[] args) {
		
		char grade;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요(0~100): ");
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
		
		System.out.println("학점은 " + grade + "입니다.");
		
		sc.close();
		
	}
	
}