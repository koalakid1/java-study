public class stringfunction{
	
	public static void main(String[] args) {
		String s1 = "Hello World";
		System.out.println(s1.length());
		String s2 = "010-1111-2222";
		System.out.println(s2.replace("-", "."));
		System.out.println(s2);
	
		String data = "이순신,010-1111-2222,컴퓨터공학과"; //csv
		String[] dataArray = data.split(",");
		for (int i = 0; i < dataArray.length; i++) {
			System.out.println(dataArray[i]);
		}
		
		String fileName = "HelloWorld.java";
		System.out.println(fileName.substring(5));
		System.out.println(fileName.substring(5,6));
		System.out.println(fileName.substring(fileName.indexOf('.')+1));
		
		String fileName3 = "a.b.c.mp3";
		System.out.println(fileName3.substring(fileName3.indexOf('.')+1));
		System.out.println(fileName3.substring(fileName3.lastIndexOf('.')+1));
		
		String fileName4 = "abcd.zip";
		fileName4.
		
	}
	
}