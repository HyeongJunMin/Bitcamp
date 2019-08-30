package bit.com.a.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BbsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//검색기능 관련
	private String s_category;	//"", title, contents, writer 
	private String s_keyword;	//검색어
	
	//페이징 기능 관련
	private int pageNumber = 0;				//현재 페이지
	private int recordCountPerPage = 10;	//페이지 당 보여 줄 글 수
	
	//페이징 기능 관련_어디 부터 어디까지 불러올 것인지
	private int start = 1;
	private int end = 10;
	
	public BbsParam() {
	}

	@Builder
	public BbsParam(String s_category, String s_keyword, int pageNumber, int recordCountPerPage, int start, int end) {
		super();
		this.s_category = s_category;
		this.s_keyword = s_keyword;
		this.pageNumber = pageNumber;
		this.recordCountPerPage = recordCountPerPage;
		this.start = start;
		this.end = end;
	}	

}
