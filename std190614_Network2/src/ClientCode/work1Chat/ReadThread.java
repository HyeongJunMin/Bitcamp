package work1Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ReadThread extends Thread{
	
	Socket sck ;
	FrameChat f;
	
	public ReadThread() {
		new FrameChat();
	}
	
	public ReadThread(Socket sck) {
		this.sck = sck;
		this.f = new FrameChat(sck);
		SingleFrame.getinstance();
		SingleFrame.s.add(this.sck);
	}
	
	public ReadThread(InetSocketAddress sckAdd) {
		sck = new Socket();
		try {
			sck.connect(sckAdd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		InetAddress intAdd;
		
		if(  (intAdd = sck.getInetAddress()) != null ) {
			System.out.println("서버연결 성공 : " + intAdd);
			SingleFrame.getinstance();
			
		}else{
			System.out.println("서버 연결 실패");
		}

		this.f = new FrameChat(sck);
		SingleFrame.getinstance();
		SingleFrame.s.add(this.sck);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			while (true) {
				// recv
//				for(Socket sckk : SingleFrame.s) {
//					if(sckk.equals(sck)) {
//					BufferedReader br = new BufferedReader(new InputStreamReader(sckk.getInputStream()));
//					String str2 = br.readLine();
//					this.f.chatBrd.append(str2+"\n");
//					str2 = "";
//					System.out.println("이거된거다" + this.toString());
//					}
//				}
				System.out.println("sck List 길이 : " + SingleFrame.s.size());
				BufferedReader br = new BufferedReader(new InputStreamReader(sck.getInputStream()));
				String str2 = br.readLine();
				this.f.chatBrd.append(str2+"\n");
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
