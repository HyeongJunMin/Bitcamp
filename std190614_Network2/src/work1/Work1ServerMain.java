package work1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Work1ServerMain {
	public static void main(String[] args) {
		
		ServerSocket serSck = null;
		
		try {
			serSck = new ServerSocket(9000);
			
			List<Socket> lst = new ArrayList<Socket>();
			
			while(true) {
				System.out.println("¥Î±‚¡ﬂ...");
				
				Socket sck = serSck.accept();
				lst.add(sck);
				new Work1ServerThread(sck, lst).start();
				System.out.println(lst.size());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
