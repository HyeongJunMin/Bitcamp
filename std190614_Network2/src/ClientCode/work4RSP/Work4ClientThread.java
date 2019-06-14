package work4RSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Work4ClientThread extends Thread{

	Socket sck;
	Work4ClientFrame wf;
	
	public Work4ClientThread() {}
	public Work4ClientThread(Socket sck, Work4ClientFrame wf) { 
		this.sck = sck;
		this.wf = wf;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(sck.getInputStream()));
				
				String str = br.readLine();
				
				wf.lbl3.setText(str);
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
