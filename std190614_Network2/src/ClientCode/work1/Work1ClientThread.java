package work1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import work1Chat.SingleFrame;

public class Work1ClientThread extends Thread {
	
	private Socket sck;
	private Work1ClientFrame form;
	
	public Work1ClientThread () {
		
	}
	
	public Work1ClientThread (Socket sck, Work1ClientFrame form) {
		this.sck = sck;
		this.form = form;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		String str2 = "";
		try {
			while (true) {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(sck.getInputStream()));
				
				str2 = br.readLine();
				if(str2.equals("") == false) {
					form.tf1.setText(str2);
				}
				str2 = "";
				System.out.println("이거된거다" + this.toString());
				
				Thread.sleep(100);
			}
			
		} catch (IOException e) {
			System.out.println("스레드 에러발생 스레드:" + this.toString());
		} catch (InterruptedException ee) {
			System.out.println("스레드 에러발생 스레드: 슬립");
		}
	}
}
