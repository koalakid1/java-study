package exercise;

public class usemouse {
	public static void main(String[] args) {
		mouse a = new mouse();
		scroll b = new scroll();
		scroll c = new razer();
		
		a.mouseMove();
		a.leftmouse();
		a.mouseMove();
		a.rightmouse();
		a.mouseMove();
		b.scrollwheel();
		b.mouseMove();
		c.scrollwheel();
		c.mouseMove();
	}
}
