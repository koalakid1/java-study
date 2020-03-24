package AutoBoxing;

public class AutoBoxing {
	public static void main(String[] args) {
		int n = 10;
		Integer intobject = n;
		System.out.println("intobject : " + intobject);
		
		int m = intobject + 10;
		System.out.println(" m = " + m);
	}
}
