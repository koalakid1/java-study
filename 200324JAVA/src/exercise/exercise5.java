package exercise;

public class exercise5 {
	public static void main(String[] args) {
		
		String csv = "ȫ�浿,010-1111-2222,hkd@hkd.com";
		String[] csvfile = csv.split(",");
		for (String string : csvfile) {
			System.out.println(string);
		}
		
	}
}
