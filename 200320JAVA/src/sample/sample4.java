package sample;

public class sample4 {
	
	int radius;
	String name;
	
	
	
	
	public sample4() { radius = 1; name = ""; }
	 
	 
	
	public sample4(int r, String n) {
		radius = r; name = n;
	}
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	
	public static void main(String[] args) {
		sample4 pizza;
		pizza = new sample4(10,"�ڹ�����");

		double area = pizza.getArea();
		System.out.println(pizza.name + "�� ������ " + area);
		
		sample4 donut = new sample4();
		donut.name = "�ڹٵ���";
		area = donut.getArea();
		System.out.println(donut.name + "�� ������ " + area);
	}
	
	
	
}
