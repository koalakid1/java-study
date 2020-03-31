package haksa;

class TimerThread extends Thread{
	
	int n = 0;
	
	@Override
	public void run() {
		while (true) {
			System.out.println(n);
			n++;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;// TODO: handle exception
			}
		}
		
	}
	
}

class TimerRunnable implements Runnable{
	
	int n = 0;
	
	@Override
	public void run() {
		while (true) {
			System.out.println(n);
			n++ ;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;// TODO: handle exception
			}
		}
		
	}
	
}


public class TestThread {
	public static void main(String[] args) {
		TimerThread th = new TimerThread();
		th.start();
		
		Thread th2 = new Thread(new TimerRunnable());
		th2.start();
	}
}
