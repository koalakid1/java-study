package sample;

public class sample6 {
	String title;
	String author;
	
	void show() {
		System.out.println(title + " " + author);
	}
	
	public sample6() {
		this("","");
		System.out.println("������ ȣ���.");
	}
	
	public sample6(String title) {
		this(title,"���ڹ̻�");
	}
	
	public sample6(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public static void main(String[] args) {
		sample6 littlePrince = new sample6("�����", "�������丮");
		sample6 loveStory = new sample6("������");
		sample6 emptyBook = new sample6();
		loveStory.show();
	}
	
}
