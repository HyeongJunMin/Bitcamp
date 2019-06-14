package serverTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReadThread extends Thread {
	
	Socket socket;
	ClientFrame cw;
	
	public ReadThread(Socket socket, ClientFrame cw) {
		this.socket = socket;
		this.cw = cw;		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {						
			while(true) {			
				// recv
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());				
				cw.dto = (DtoClass)ois.readObject();						
			}		
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
}
