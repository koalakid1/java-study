package ex;

public class ex5 {
	public static void main(String[] args) {
		for (int i = -1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				if (i == -1) System.out.print(j+"´Ü\t");
				else if (i == 0) System.out.print("--------");
				else System.out.print(j+"*"+i+"="+ j * i +"\t");
			}
			System.out.println("|");
	}
}
}

