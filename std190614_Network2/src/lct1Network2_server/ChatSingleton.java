package lct1Network2_server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatSingleton {
	private static ChatSingleton single = null;
	public static List<Socket> list;
	
	private ChatSingleton() {
		list = new ArrayList<Socket>();
	}
	
	public static ChatSingleton getInstance() {
		if(single == null) {
			single = new ChatSingleton();
		}
		return single;
	}
	
	
}
