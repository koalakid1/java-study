package human;

public class human {
	
	public static void main(String[] args) {
		person p1 = new person("���¹�",26);

		p1.showMe();
		
		person[] persons = new person[3];
		persons[0] = new person("�̼���", 25);
		persons[1] = new person("�հ�", 33);
		persons[2] = new person("��������", 55);
		
		for (person person : persons) {
			System.out.println(person.name + " : " + person.age);
		}
	}
	
}
