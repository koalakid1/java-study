import java.util.Scanner;

public class exercise3{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�л� ���� �Է��ϼ���.");
		int n = sc.nextInt();
		
		double array[] = new double[n];
		double korean,english,methematics,average;
		
		for (int i = 0; i < n; i++) {
			System.out.println("����,����,���� ������ ���ʷ� �Է��ϼ���.");
			korean = sc.nextDouble();
			english = sc.nextDouble();
			methematics = sc.nextDouble();
			
			average = (korean + english + methematics)/3;

			array[i] = average;
			
		}
		
		double sum = 0;
		System.out.print("ù��° ������� ������� ��� : ");
		for (double d : array) {
			sum += d;
			System.out.println(d + "��");
		}
		System.out.println("�б� ��ü ���: "+sum/n + "��");
		
	}
	
}