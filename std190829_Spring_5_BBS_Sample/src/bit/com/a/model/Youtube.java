package bit.com.a.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**출력 용도로 사용하기 위한 
 * @author bitcamp88
 *
 */
@Getter
@Setter
@ToString
public class Youtube implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String url;
	private String vname;
	private String img;
	
	@Builder
	public Youtube() {	}

	@Builder
	public Youtube(String title, String url, String img) {
		super();
		this.title = title;
		this.url = url;
		this.img = img;
	}

	
	public Youtube(String title, String url, String vname, String img) {
		super();
		this.title = title;
		this.url = url;
		this.vname = vname;
		this.img = img;
	}

	public String getVname() {
		//return url;
		return toUrl(this.url);
	}
	
	/** =를 제거한 유튜브 영상 고유번호
	 * 
	 */
	public String toUrl(String msg) {		
		if( msg.indexOf("=") == -1 ) {
			return msg;
		}else {
			return msg.substring(msg.indexOf("=")+1, msg.length() );
		}
	}

}

