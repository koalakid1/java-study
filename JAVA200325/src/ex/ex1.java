package ex;

import java.util.ArrayList;

class Student{
	
	public String name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name) {
		
		this.name = name;
		
	}
}

public class ex1 {
	public static void main(String[] args) {
		
		ArrayList<Student> a = new ArrayList<Student>();
		a.add(new Student());
		a.add(new Student("ȫ�浿"));
		
		Student b = a.get(0);
		System.out.println(b.name);
		System.out.println(a.get(1).name);
	}
}
