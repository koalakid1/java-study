import java.util.Scanner;

public class sample3 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ 5�� �Է��ϼ���.");
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int n = sc.nextInt();
			if (n<=0) {
				continue;
			}
			sum += n;
		}
		System.out.println("����� ����" + sum);
		
		sc.close();
		
	}
	
}