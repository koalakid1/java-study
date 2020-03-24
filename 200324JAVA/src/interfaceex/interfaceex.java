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
		System.out.println("�츮��������");// TODO Auto-generated method stub
		
	}

	@Override
	public void receivecall() {
		System.out.println("��ȭ�� �Խ��ϴ�.");// TODO Auto-generated method stub
		
	}

	@Override
	public void sendSMS() {
		System.out.println("���ڰ��ϴ�.");// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveSMS() {
		System.out.println("���ڿԾ��.");// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		System.out.println("���� �����մϴ�.");// TODO Auto-generated method stub
		
	}

	
	public void schedule() {
		System.out.println("���� �����մϴ�.");
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
		System.out.println("3�� 5�� ���ϸ� "+phone.calculate(3, 5));
		phone.schedule();
	}
		
}
