package sample;

public class sample3 {

	int radius;
	String name;
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	
	public static void main(String[] args) {
		sample3 pizza;
		pizza = new sample3();
		pizza.radius = 10;
		pizza.name = "�ڹ�����";
		double area = pizza.getArea();
		System.out.println(pizza.name + "�� ������ " + area);
		
		sample3 donut = new sample3();
		donut.radius = 2;
		donut.name = "�ڹٵ���";
		area = donut.getArea();
		System.out.println(donut.name + "�� ������ " + area);
	}
	
}
