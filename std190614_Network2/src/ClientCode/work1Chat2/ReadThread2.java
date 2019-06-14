package work1Chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread2 extends Thread {
	Socket sck;
	FrameChat2 fChat;
	
	
	public ReadThread2(Socket sck, FrameChat2 fChat) {	//소켓과 폼정보를 받아오는 생성자
		this.sck = sck;
		this.fChat = fChat;
		FrameLogin fff = new FrameLogin(this.fChat);
	}
	
	@Override
	public void run() {
		super.run();
		
		while(true) {
			
			
			try {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(sck.getInputStream()));
				
				String strIn = br.readLine();
				this.fChat.chatBrd.append( strIn + "\n");
				
				Thread.sleep(100);
			} catch (IOException e) {
				System.out.println("Read Exception In Read Thread");
			} catch (InterruptedException e) {
				System.out.println("Thread Sleep Exception In Read Thread");
			}
		}
	}
}
