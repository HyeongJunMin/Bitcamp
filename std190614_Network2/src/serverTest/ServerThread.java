package serverTest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ServerThread extends Thread {
	
	private Socket socket;
	private List<Socket> list;
	
	public ServerThread(Socket socket, List<Socket> list) {
		this.socket = socket;
		this.list = list; 
	}

	@Override
	public void run() {		
		super.run();
		
		try {
			while(true) {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				DtoClass dto = (DtoClass)ois.readObject();
				// 異쒕젰
				System.out.println("Transported Object:" + dto.toString());
				if(dto.getClientNumber() == 1) {
					dto.setClientNumber(2);
				}else {
					dto.setClientNumber(1);
				}
							
				for (Socket s : list) {
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(dto);
					oos.flush();
				}			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
