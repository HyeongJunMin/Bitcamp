package work4RSP;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import work3SetAllLabel.Work3ClientFrame;

public class Work4ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int port = 9000;
		String addr = "192.168.0.29";
		
		Socket sck = new Socket();
		
		InetSocketAddress sckAddr = new InetSocketAddress(addr, port);
		
		try {
			sck.connect(sckAddr);	//설정한 IP와 Port에 맞는 서버와 연결
			new Work4ClientFrame(sck);	//연결된 소켓을 프레임에 전달
			System.out.println("연결 성공!");
		} catch (IOException e) {
			System.out.println("연결 실패");
		}
	}

}
