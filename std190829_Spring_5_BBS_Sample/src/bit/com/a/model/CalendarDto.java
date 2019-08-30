package bit.com.a.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CalendarDto {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String rdate;	//예약 날짜
	private String wdate;	//예약한 날짜 
	
	public CalendarDto() {}

	@Builder
	public CalendarDto(int seq, String id, String title, String content, String rdate, String wdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
		this.wdate = wdate;
	}		
}
