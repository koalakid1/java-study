package exercise;

interface mouseinterface{
	public String mousemove(); 
}


class normalmouse implements mouseinterface {
	String mouse;
	public normalmouse() {
		this.mouse = "stay";
	}
	public normalmouse(int k) {
		switch (k) {
		case 1:
			this.mouse = "왼쪽 버튼 누름";
			break;
		case 2:
			this.mouse = "오른쪽 버튼 누름";
			break;
		case 3:
			this.mouse = "움직임";
		default:
			break;
		}
		this.mouse = mouse;
	}
	
	@Override
	public String mousemove() {
		// TODO Auto-generated method stub
		return this.mouse;
	}
	
	
	
}

class scroll implements mouseinterface{

	@Override
	public String mousemove() {
		// TODO Auto-generated method stub
		return "scroll";
	}
	
	
}

class razer extends scroll{
	
	@Override
	public String mousemove() {
		// TODO Auto-generated method stub
		return "razer";
	}
	
}

public class usemouse {
	public static void main(String[] args) {
		normalmouse a = new normalmouse(1);
		normalmouse b = new normalmouse(2);
		normalmouse c = new normalmouse(3);
		scroll d = new scroll();
		scroll e = new razer();
		
		System.out.println(a.mousemove());
		System.out.println(b.mousemove());
		System.out.println(c.mousemove());
		System.out.println(d.mousemove());
		System.out.println(e.mousemove());
	}
}
