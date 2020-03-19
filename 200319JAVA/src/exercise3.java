import java.util.Scanner;

public class exercise3{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 수를 입력하세요.");
		int n = sc.nextInt();
		
		double array[] = new double[n];
		double korean,english,methematics,average;
		
		for (int i = 0; i < n; i++) {
			System.out.println("국어,영어,수학 점수를 차례로 입력하세요.");
			korean = sc.nextDouble();
			english = sc.nextDouble();
			methematics = sc.nextDouble();
			
			average = (korean + english + methematics)/3;

			array[i] = average;
			
		}
		
		double sum = 0;
		System.out.print("첫번째 사람부터 순서대로 평균 : ");
		for (double d : array) {
			sum += d;
			System.out.println(d + "점");
		}
		System.out.println("학급 전체 평균: "+sum/n + "점");
		
	}
	
}