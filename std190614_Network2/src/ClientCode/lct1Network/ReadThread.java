package lct1Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {
	private Socket sck;

	public ReadThread(Socket sck) {
		this.sck = sck;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			while (true) {
				// recv
				BufferedReader br = new BufferedReader(new InputStreamReader(sck.getInputStream()));
				String str2 = br.readLine();
				System.out.println("서버에서 받아온 문자열:" + str2);
				Thread.sleep(100);
			}
		} catch (IOException e) {
			System.out.println("스레드 에러발생 스레드:" + this.toString());
		} catch (InterruptedException ee) {
			System.out.println("스레드 에러발생 스레드: 슬립");
		}
			
	}

}
