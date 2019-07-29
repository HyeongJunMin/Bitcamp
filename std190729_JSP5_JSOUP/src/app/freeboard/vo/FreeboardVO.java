package app.freeboard.vo;
 
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreeboardVO {
	private int seq;
	private String id;
	private String title;
	private String content;
	private Date wdate;
	private int del;
	private int readcount;
}
