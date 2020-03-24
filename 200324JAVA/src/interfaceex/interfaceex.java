package interfaceex;

interface phoneinterface{
	
	final int timeout = 10000;
	void sendcall();
	void receivecall();
	default void printlogo() {
		
		System.out.println("** phone **");
		
	}
	
}

interface mobilephoneinterface extends phoneinterface{
	
	void sendSMS();
	void receiveSMS();
	
}

interface MP3Interface{
	public void play();
	public void stop();
}

class PDA{
	
	public int calculate(int x, int y) {
		
		return x+y;
	}
	
}


class smartphone extends PDA implements MP3Interface,mobilephoneinterface, phoneinterface{

	@Override
	public void sendcall() {
		System.out.println("띠리리리리링");// TODO Auto-generated method stub
		
	}

	@Override
	public void receivecall() {
		System.out.println("전화가 왔습니다.");// TODO Auto-generated method stub
		
	}

	@Override
	public void sendSMS() {
		System.out.println("문자갑니다.");// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveSMS() {
		System.out.println("문자왔어요.");// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		System.out.println("음악 연주합니다.");// TODO Auto-generated method stub
		
	}

	
	public void schedule() {
		System.out.println("일정 관리합니다.");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
}

public class interfaceex {
	public static void main(String[] args) {
		smartphone phone = new smartphone();
		phone.printlogo();
		phone.sendcall();
		phone.play();
		System.out.println("3과 5를 더하면 "+phone.calculate(3, 5));
		phone.schedule();
	}
		
}
