package exercise;

public class exercise6 {
	public static void main(String[] args) {
		String csv = "EL201800001,CH201800021,EN12231";
		String[] csvfile = csv.split(",");
		for (String string : csvfile) {
			string = string.substring(0,2);
			switch (string) {
			case "EL":
				System.out.println("���ڰ��а�");
				break;
			case "CH":
				System.out.println("ȭ�а��а�");
				break;
			case "EN":
				System.out.println("������а�");
				break;
			}
		}
	}
}
