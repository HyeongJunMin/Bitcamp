package bit.com.a.bbs.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchDto extends PagingVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 검색조건. 0=제목, 1=내용 2=id*/
	private int cond;	
	
	private String condquery = "";
	
	/** 검색어 */
	private String keyword;

	
	public SearchDto(int cond, String keyWord) {
		super();
		this.cond = cond;
		this.keyword = keyWord;
	}	
	
	public SearchDto(int cond, String keyword, int pageNum, int totalSize) {
		super(pageNum, totalSize);
		this.cond = cond;
		this.keyword = keyword;
		switch( cond ) {
			case 0: this.condquery=" TITLE "; break;
			case 1: this.condquery=" CONTENT "; break;
			case 2: this.condquery=" ID "; break;
			default: this.condquery= " TITLE "; break;
		}		
	}
}
