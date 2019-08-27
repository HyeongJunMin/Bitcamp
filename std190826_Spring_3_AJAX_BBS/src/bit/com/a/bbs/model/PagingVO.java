package bit.com.a.bbs.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PagingVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 현재페이지 */
	private int pageIndex = 1;
	
	/** 페이지에 보여줄 데이터 갯수 */
	private int recordCountPerPage = 10;
		
	/** 현재 페이지의 시작 seq	 */
	private int startSeq = 1;
	
	/** 현재 페이지의 끝 seq */
	private int endSeq = 10;
		
	/**총 페이지 수 */
	private int totalPage = 1;

	/** 페이지 네비게이션 사이즈 */
	private int pageSize = 5;

	/** 페이지 네비게이션 첫 인덱스 */
	private int firstNavIndex = 1;

	/** 페이지 네비게이션 마지막 인덱스 */
	private int lastNavIndex = 1;	

	/** 검색 제한 레코드 시작 위치 */
	// private int limitOffSet = 1;
	
	
	/** All Args Constructor
	 * @param pageIndex
	 * @param recordCountPerPage
	 * @param startSeq
	 * @param endSeq
	 * @param totalPage
	 * @param pageSize
	 * @param firstNavIndex
	 * @param lastNavIndex
	 */
	@Builder
	public PagingVO(int pageIndex, int recordCountPerPage, int startSeq, int endSeq, int totalPage, int pageSize,
			int firstNavIndex, int lastNavIndex) {
		super();
		this.pageIndex = pageIndex;
		this.recordCountPerPage = recordCountPerPage;
		this.startSeq = startSeq;
		this.endSeq = endSeq;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.firstNavIndex = firstNavIndex;
		this.lastNavIndex = lastNavIndex;
	}

	public int getPageIndex() {
		if (pageIndex == 0) { // 값 셋팅없이 사용되는 경우(페이지 최초 접근)
			return 1;
		} else {
			return pageIndex;
		}
	}

	
}
