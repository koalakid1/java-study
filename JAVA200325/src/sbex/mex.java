package sbex;

import java.util.Calendar;

public class mex {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int n = (int)(Math.random()*100 + 1 );
			System.out.println(n);
		}
		
		System.out.println(Math.PI);
		System.out.println(Math.ceil(0.555));
		System.out.println(Math.floor(0.555));
		System.out.println(Math.sqrt(9));
		System.out.println(Math.round(3.14));
		System.out.println(Math.exp(2));
		
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		System.out.println(now.get(Calendar.YEAR));
		System.out.println(now.get(Calendar.MONTH)+1);
		System.out.println(now.get(Calendar.HOUR));
		System.out.println(now.get(Calendar.MINUTE));
		System.out.println(now.get(Calendar.SECOND));
		System.out.println(now.get(Calendar.MILLISECOND));
		System.out.println(now.get(Calendar.DAY_OF_WEEK));
		
		int dayofweek = now.get(Calendar.DAY_OF_WEEK);
		
		if (dayofweek == Calendar.SUNDAY) {
			System.out.println("�Ͽ���");
		}
		else if (dayofweek == Calendar.MONDAY) {
			System.out.println("������");
		}
		else if (dayofweek == Calendar.TUESDAY) {
			System.out.println("ȭ����");
		}
		else if (dayofweek == Calendar.WEDNESDAY) {
			System.out.println("������");
		}
		else if (dayofweek == Calendar.THURSDAY) {
			System.out.println("�����");
		}
		else if (dayofweek == Calendar.FRIDAY) {
			System.out.println("�ݿ���");
		}
		else if (dayofweek == Calendar.SATURDAY) {
			System.out.println("�����");
		}
		
	}
}
