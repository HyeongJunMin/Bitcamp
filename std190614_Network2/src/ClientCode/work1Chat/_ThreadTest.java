package work1Chat;

public class _ThreadTest extends Thread{

	public _ThreadTest() {
		new _FrameTest();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		System.out.println("스레드");
	}
	
}
