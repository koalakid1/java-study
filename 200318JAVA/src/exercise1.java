import java.util.Scanner;

public class exercise1{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�̸�, �й�, �а��� ������� �Է��ϼ���.");
		
		String st_name = sc.next();
		long st_id = sc.nextLong();
		String st_major = sc.next();
		
		System.out.println(st_name+" �л��� �й��� "+st_id+"�̰� �а��� "+st_major+"�Դϴ�.");		
	}
	
}