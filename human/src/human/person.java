package human;

public class person {
	public String name;
	public int age;
	
	public person() {}
	
	public person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void showMe() {
		System.out.println(this.name + " : " + this.age);
	}
}
