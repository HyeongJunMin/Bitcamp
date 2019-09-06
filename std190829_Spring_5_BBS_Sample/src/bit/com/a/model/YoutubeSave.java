package bit.com.a.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class YoutubeSave implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int seq;
	private String vname;
	private String id;
	private String title;
	private String category;
	private Date wdate;
	
	/**No args con
	 * 
	 */
	@Builder
	public YoutubeSave() {	}
	
	@Builder
	public YoutubeSave(String vname, String id, String title, String category, Date wdate) {
		this.vname = vname;
		this.id = id;
		this.title = title;
		this.category = category;
		this.wdate = wdate;
	}
	
	@Builder
	public YoutubeSave(String vname, String id, String title, String category) {
		this.vname = vname;
		this.id = id;
		this.title = title;
		this.category = category;
	}
	
	/**All args con
	 * @param seq
	 * @param vname
	 * @param id
	 * @param title
	 * @param category
	 * @param wdate
	 */
	@Builder
	public YoutubeSave(int seq, String vname, String id, String title, String category, Date wdate) {
		super();
		this.seq = seq;
		this.vname = vname;
		this.id = id;
		this.title = title;
		this.category = category;
		this.wdate = wdate;
	}			
}
