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
			//1 승리 경우
			//바위-가위, 가위-보, 보-바위
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
				// 소켓으로부터 정보를 받을 스트림과 리더 선언 및 생성
				ObjectInputStream ois = new ObjectInputStream(sck.getInputStream());
				RSPDTO obj = (RSPDTO)ois.readObject();
				
				System.out.println("읽을준비끝");
								
				System.out.println("Message From Client: " + obj.toString()); // 클라이언트 메시지 확인
				
				//recv한 RSPDTO가 맵에 있으면? replace 없으면? put
				if( sckM.containsKey(sck) ) {
					sckM.replace(sck, obj);
				}else {
					sckM.put(sck, obj);
				}
				
				String annWinner = "";
				//sckM에 요소가 2개 있으면?
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


				System.out.println("보내기도 끝");
					
		
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception ee) {
				System.out.println("Ex in Thread");
			}
	
		
	}
}
