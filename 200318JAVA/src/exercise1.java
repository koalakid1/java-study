import java.util.Scanner;

public class exercise1{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름, 학번, 학과를 순서대로 입력하세요.");
		
		String st_name = sc.next();
		long st_id = sc.nextLong();
		String st_major = sc.next();
		
		System.out.println(st_name+" 학생의 학번은 "+st_id+"이고 학과는 "+st_major+"입니다.");		
	}
	
}