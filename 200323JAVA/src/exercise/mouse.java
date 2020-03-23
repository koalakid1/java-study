package exercise;

class mouse{
	
	public String mousebutton;
	
	public mouse() {
		
		this.mousebutton = "None";
		
	}
	
	public void leftmouse(){
		
		this.mousebutton = "left";
		
	}
	
	public void rightmouse(){
		
		this.mousebutton = "right";
		
	}
	
	public void mouseMove() {
		System.out.println(this.mousebutton);
	}
}
