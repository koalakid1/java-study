import java.util.Scanner;

public class sample5 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int array[] = new int[5];
		
		int max = 0;
		System.out.println("��� 5���� �Է��ϼ���.");
		for (int i = 0; i < 5; i++) {
			
			array[i] = sc.nextInt();
			if (array[i]>max) {
				max = array[i];
			}
			
		}
		System.out.println("���� ū ����"+max+"�Դϴ�.");
		
		sc.close();
		
	}
	
}