import java.util.Scanner;

public class sample5 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int array[] = new int[5];
		
		int max = 0;
		System.out.println("양수 5개를 입력하세요.");
		for (int i = 0; i < 5; i++) {
			
			array[i] = sc.nextInt();
			if (array[i]>max) {
				max = array[i];
			}
			
		}
		System.out.println("가장 큰 수는"+max+"입니다.");
		
		sc.close();
		
	}
	
}