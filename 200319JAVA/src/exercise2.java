import java.util.Scanner;

public class exercise2{
	
	public static void main(String[] args) {
		int count = 0;
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϰ� �������� -1�� �Է��ϼ���.");
		
		int n = sc.nextInt();
		do {
			sum += n;
			count++;
			n= sc.nextInt();
		} while (n!=-1);
	
		
		if (count == 0) {
			System.out.println("�Էµ� ���� �����ϴ�.");
		}
		else {
			System.out.print("������ ������ " + count + "���̸� ");
			System.out.println("����� "+ (double)sum/count + "�Դϴ�.");
		}
		sc.close();
		
		
	}
	
	
	
}