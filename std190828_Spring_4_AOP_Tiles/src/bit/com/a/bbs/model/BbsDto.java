package bit.com.a.bbs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BbsDto {
	private int rnum;
	private int seq;
	private String id;
	private int ref;
	private int step;
	private int depth;
	private String title;
	private String content;
	private String wdate;
	private int parent;
	private int del;
	private int readcount;
	
	//새 글 작성 시 활용하기 위한 생성자
	public BbsDto(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}	
	
}
