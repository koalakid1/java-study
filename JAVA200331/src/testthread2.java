
class Thread1 extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("Thread1 : " + i);
		}
	}
	
}

public class testthread2 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 10000; i++) {
			System.out.println("Main Thread : " + i);
		}
		
		Thread1 th = new Thread1();
		th.start();
		
	}
}
