package work4RSP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

import workDTO.RSPDTO;

public class Work4ServerThread extends Thread {
	Socket sck;
	Map<Socket, RSPDTO> sckM;
	public Work4ServerThread() { }
	public Work4ServerThread(Socket sck, Map<Socket, RSPDTO> m) {
		this.sck = sck;
		this.sckM = m;
	}
	
	public int judgeWinner(Map<Socket, RSPDTO> m) {
		Socket p1s, p2s;
		int p1n, p2n, winN;
		
		Iterator it = m.keySet().iterator();
		
		p1s = (Socket)it.next();
		p2s = (Socket)it.next();
		
		p1n = m.get(p1s).getInputNum();
		p2n = m.get(p2s).getInputNum();
		
		if( p1n == p2n ) {
			winN = 0;
		}else if( p1n == 0 && p2n == 1 ||	p1n == 1 && p2n == 2 ||	p1n == 2 && p2n == 0 ){
			//1 �¸� ���
			//����-����, ����-��, ��-����
			winN = 1;
		}else {
			winN = 2;
		}
		System.out.println("winN"+winN);
		return winN;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			
			while(true) {
				// recv
				// �������κ��� ������ ���� ��Ʈ���� ���� ���� �� ����
				ObjectInputStream ois = new ObjectInputStream(sck.getInputStream());
				RSPDTO obj = (RSPDTO)ois.readObject();
				
				System.out.println("�����غ�");
								
				System.out.println("Message From Client: " + obj.toString()); // Ŭ���̾�Ʈ �޽��� Ȯ��
				
				//recv�� RSPDTO�� �ʿ� ������? replace ������? put
				if( sckM.containsKey(sck) ) {
					sckM.replace(sck, obj);
				}else {
					sckM.put(sck, obj);
				}
				
				String annWinner = "";
				//sckM�� ��Ұ� 2�� ������?
				if(sckM.size() == 2) {
					int winner = judgeWinner(sckM);
					switch(winner) {
						case 0: annWinner = "Result : No Winner"; break;
						case 1: annWinner = "Result : Winner is Player 1!"; break;
						case 2: annWinner = "Result : Winner is Player 2"; break;
						default : break;
					}
					
					PrintWriter wr;
					Iterator it = sckM.keySet().iterator();
					while( it.hasNext() ) {
						Socket t = (Socket)it.next();
						wr = new PrintWriter(t.getOutputStream());
						wr.println(annWinner);
						wr.flush();
					}					
				}
				
//				Iterator it = sckM.keySet().iterator();
//				while( it.hasNext() ) {
//					Socket itSck = (Socket)it.next();
//				}
				
				// send


				System.out.println("�����⵵ ��");
					
		
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception ee) {
				System.out.println("Ex in Thread");
			}
	
		
	}
}
