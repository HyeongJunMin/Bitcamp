package bit.com.a.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PdsDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//일반 게시판과 유사
	private int seq;
	private String id;
	private String title;
	private String content;	
	
	private String filename;//업로드된 파일 이름(저장하기위해 바뀐) 사실 오리지널 이름이 있어야함
	private int readcount;
	private int downcount;//다운 수
	private String regdate;//등록일
	
	//유저 입력값만 받는 생성자
	@Builder
	public PdsDto(String id, String title, String content, String filename) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
	}	
	
	//수정용 생성자
	@Builder
	public PdsDto(int seq, String id, String title, String content, String filename) {
			this.seq = seq;
			this.id = id;
			this.title = title;
			this.content = content;
			this.filename = filename;
	}	
}