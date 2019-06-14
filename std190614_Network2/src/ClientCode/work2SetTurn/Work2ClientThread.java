package work2SetTurn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Work2ClientThread extends Thread{

	private Socket sck;
	private Work2ClientFrame cf;
		
	
	public Work2ClientThread() {}
	public Work2ClientThread(Socket sck) {
		this.sck = sck;
	}
	public Work2ClientThread(Socket sck, Work2ClientFrame cf) {
		this.sck = sck;
		this.cf = cf;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			
			
			try {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(sck.getInputStream()));
				
				String strIn = br.readLine();
				
				System.out.println("read ok : " + strIn);
				if( Boolean.parseBoolean(strIn) ) {
					cf.btnVisible = true;
					cf.tf1.setText("can use");
					System.out.println("change true" + cf.btnVisible);
				}else {
					cf.btnVisible = false;
					cf.tf1.setText("can not use");
					System.out.println("change false" + cf.btnVisible);
				}
				
				Thread.sleep(100);
			} catch (IOException e) {
				System.out.println("Read Exception In Read Thread");
			} catch (InterruptedException e) {
				System.out.println("Thread Sleep Exception In Read Thread");
			}
		}
		
	}
}
