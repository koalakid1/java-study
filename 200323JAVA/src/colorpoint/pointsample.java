package colorpoint;

class point{
	
	public int x;
	public int y;
	
	public point(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
}

class colorpointer extends point{
	
	public String color;
	public colorpointer(int x, int y, String color) {
		
		super(x,y);
		this.color = color;
		
	}
	
}


public class pointsample {
	public static void main(String[] args) {
		colorpointer cp = new colorpointer(10, 10, "red");
	}
}
