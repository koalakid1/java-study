package exercise;

public class Member {
	
	String name;
	String address;
	String job;
	int age;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Member(String name, String address, String job, int age) {
		this.address = address;
		this.age = age;
		this.job = job;
		this.name = name;
	}
	
	public void showInfo() {
		System.out.println("�̸� : " + this.name + ", �ּ� : " + this.address +
				", ���� : " + this.job + ", ���� : " + this.age);
	}
	
}
