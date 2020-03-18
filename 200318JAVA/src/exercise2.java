import java.util.Scanner;

public class exercise2{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 영어 수학 성적을 차례대로 입력하세요.");
		
		double korean = sc.nextDouble();
		double english = sc.nextDouble();
		double mathematics = sc.nextDouble();
		
		double average = (korean + english + mathematics) / 3;
		
		System.out.println("이번 학기 성적 평균은 "+ average + "입니다.");		
	}
	
}