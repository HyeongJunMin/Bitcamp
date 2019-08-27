package bit.com.a.bbs.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchDto {
	/** 검색조건. 0=제목, 1=내용 2=id*/
	private int cond;	
	
	/** 검색어 */
	private String keyWord;

	@Builder
	public SearchDto(int cond, String keyWord) {
		super();
		this.cond = cond;
		this.keyWord = keyWord;
	}	
}
