import java.util.Scanner;

public class sample2{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("���� Ŀ�� �帱���? ");
		String order = sc.next();
		int price = 0;
		switch (order) {
		case "����������":
		case "īǪġ��":
		case "ī���":
			price = 3500;
			break;
		case "�Ƹ޸�ī��":
			price = 2000;
			break;
		default:
			System.out.println("�޴��� �����ϴ�! ");
			
		}
		
		if (price != 0) {
			
			System.out.println(order + "�� " + price + "�� �Դϴ�.");
			
		}
		sc.close();
		
	}
	
}