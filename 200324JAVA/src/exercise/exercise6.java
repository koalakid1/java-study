package exercise;

public class exercise6 {
	public static void main(String[] args) {
		String csv = "EL201800001,CH201800021,EN12231";
		String[] csvfile = csv.split(",");
		for (String string : csvfile) {
			string = string.substring(0,2);
			switch (string) {
			case "EL":
				System.out.println("전자공학과");
				break;
			case "CH":
				System.out.println("화학공학과");
				break;
			case "EN":
				System.out.println("영어영문학과");
				break;
			}
		}
	}
}
