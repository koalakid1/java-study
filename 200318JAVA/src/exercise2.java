import java.util.Scanner;

public class exercise2{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ���� ���� ������ ���ʴ�� �Է��ϼ���.");
		
		double korean = sc.nextDouble();
		double english = sc.nextDouble();
		double mathematics = sc.nextDouble();
		
		double average = (korean + english + mathematics) / 3;
		
		System.out.println("�̹� �б� ���� ����� "+ average + "�Դϴ�.");		
	}
	
}