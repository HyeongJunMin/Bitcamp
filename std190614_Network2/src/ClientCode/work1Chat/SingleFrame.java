package work1Chat;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SingleFrame extends Thread{
	private static SingleFrame single;
	public static List<FrameChat> f;
	public static List<Socket> s;
	public static List<ReadThread> lst;
	
	private SingleFrame() {
		f = new ArrayList<FrameChat>();
		s = new ArrayList<Socket>();
		lst = new ArrayList<ReadThread>();
	}
	
	public static SingleFrame getinstance() {
		if( single == null ) {
			single = new SingleFrame();
		}
		return single;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	
}
