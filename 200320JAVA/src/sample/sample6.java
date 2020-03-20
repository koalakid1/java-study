package sample;

public class sample6 {
	String title;
	String author;
	
	void show() {
		System.out.println(title + " " + author);
	}
	
	public sample6() {
		this("","");
		System.out.println("생성자 호출됨.");
	}
	
	public sample6(String title) {
		this(title,"작자미상");
	}
	
	public sample6(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public static void main(String[] args) {
		sample6 littlePrince = new sample6("어린왕자", "생텍쥐페리");
		sample6 loveStory = new sample6("춘향전");
		sample6 emptyBook = new sample6();
		loveStory.show();
	}
	
}
