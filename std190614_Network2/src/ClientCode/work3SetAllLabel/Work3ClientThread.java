package work3SetAllLabel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Work3ClientThread extends Thread {
	
	Socket sck;
	Work3ClientFrame wf;
	
	public Work3ClientThread() {}
	public Work3ClientThread(Socket sck, Work3ClientFrame wf) {
		this.sck = sck;
		this.wf = wf;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("read ready");
		//서버가 텍스트(1,2)를 보내면 갖고있는 레이블 텍스트를 해당 텍스트로 변경
		while(true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(sck.getInputStream()));
				String str = br.readLine();
				
				wf.lbl1.setText(str);
				wf.lbl2.setText(str);
				
				str="";
				System.out.println("read ok : " + str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
