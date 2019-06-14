package work1Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import lct1Network.ReadThread;

public class FrameMain {
	
	public static void main(String[] args) {
		int port = 9000;
		String ipAdd = "192.168.0.29";
		InetSocketAddress sckAddr = new InetSocketAddress(ipAdd, port);
		
		Socket sck = new Socket();
		SingleFrame.getinstance();
//		try {
//			sck.connect(sckAddr);
//			
//			InetAddress intAdd;
//			
//			if(  (intAdd = sck.getInetAddress()) != null ) {
//				System.out.println("서버연결 성공 : " + intAdd);
//				SingleFrame.getinstance();
//				
//			}else{ 593-133-048
//				System.out.println("서버 연결 실패");
//			}
//			new work1Chat.ReadThread(sck).start();//폼뜨고 입력도 되는데 못받아옴
			new work1Chat.ReadThread(sckAddr).start();
			
//			SingleFrame s = SingleFrame.getinstance();
//			s.run();
//			s.lst.add(new work1Chat.ReadThread(sck));
//			System.out.println(s.lst.size());;
			
//		} catch (IOException e) {
//			System.out.println(e.toString());
//		}
	}
}
