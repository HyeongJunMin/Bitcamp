package bit.com.a.websock;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocket extends TextWebSocketHandler {
	
	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
			
	public WebSocket() {
		System.out.println("EchoHandler 생성됨 " + new Date() );
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("연결됨 " + new Date() );
		
		//접속한 세션의 ID와 세션정보를 Map에 등록
		users.put(session.getId(), session );		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//연결 종료
		System.out.println("연결 종료됨 " + new Date() );
		
		//연결이 종료된 세션의 ID를 Map에서 제거
		users.remove(session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//서버가 메시지를 수신했을 때 이부분이 가장 먼저 수행되는 메소드
		
		//Map이 갖고있는 모든 세션에 메시지 전송
		for( WebSocketSession s : users.values() ) {
			s.sendMessage(message);
			
			System.out.println( s.getId() + "에 메시지 발송" );
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		//예외가 발생했을 때 수행되는 메소드
		System.out.println( session.getId() + "에서 예외 발생" );
	}
	
}
