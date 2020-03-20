package human;

public class human {
	
	public static void main(String[] args) {
		person p1 = new person("ÀÌÅÂ¹Î",26);

		p1.showMe();
		
		person[] persons = new person[3];
		persons[0] = new person("ÀÌ¼ø½Å", 25);
		persons[1] = new person("¿Õ°Ç", 33);
		persons[2] = new person("À»Áö¹®´ö", 55);
		
		for (person person : persons) {
			System.out.println(person.name + " : " + person.age);
		}
	}
	
}
