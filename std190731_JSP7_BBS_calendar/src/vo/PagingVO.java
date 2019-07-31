package vo;

public class PagingVO {
	
	//	현재 페이지에 보여질 row 수
	private int rows;
	//	현재 보여질 페이지의 숫자
	private int page;
	//	총 페이지 수
	private int totalPage;
	//	시작 페이지의 숫자
	private int startPage;
	//	끝 페이지의 숫자
	private int endPage;
	//	한 페이지에 보여줄 페이지 숫자의 합계
	private int pageScale;
	
	
	public PagingVO() {	}
	
	//모든 게시글의 총 수(bbsCnt)와 한 페이지에 보여 줄 게시글의 수(bbsPerPage)를 매개변수로 받는 생성자
	public PagingVO(int bbsCnt, int bbsPerPage) {
		this.rows = bbsPerPage;
		// 총 페이지 수 계산
		// 모든 게시글의 총 수를 보여 줄 게시글의 수로 나눈 나머지가 0이면 
		//모든 게시글의 총 수를 보여 줄 게시글의 나눈 값이 총 페이지의 수(예_ 총20개/10개씩 = 2페이지)
		//그게 아니면 나눈 값 + 1 (예_ 총 21개/10개씩 = 2+1페이지)
		this.totalPage = ( (bbsCnt % rows) == 0 ) ? (bbsCnt/rows) + 1 : (bbsCnt/rows) ;
	}

	public PagingVO(int rows, int page, int totalPage, int startPage, int endPage, int pageScale) {
		super();
		this.rows = rows;
		this.page = page;
		this.totalPage = totalPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.pageScale = pageScale;
	}
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPageScale() {
		return pageScale;
	}
	public void setPageScale(int pageScale) {
		this.pageScale = pageScale;
	}
	
	
}
