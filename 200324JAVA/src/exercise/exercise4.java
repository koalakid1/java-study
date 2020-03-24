package exercise;

public class exercise4 {
	public static void main(String[] args) {
		String item = "E20160001";
		String find = "2016";
		System.out.println(item.substring(item.indexOf(find),item.indexOf("2016")+find.length()));
	}
}
