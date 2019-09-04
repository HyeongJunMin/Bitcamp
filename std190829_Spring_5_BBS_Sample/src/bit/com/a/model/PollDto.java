package bit.com.a.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**	투표 기능에서 투표 주제 정보를 담는 DTO
 * @author minhj
 *
 */
@ToString
public class PollDto implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private int pollid;	//sequence
	@Getter @Setter
	private String id;	//투표 게시자
	@Getter @Setter
	private String question;	//투표 주제
	@Getter @Setter
	private Date sdate;	//시작일
	@Getter @Setter
	private Date edate;	//종료일
	
	@Getter @Setter
	private int itemcount;	//선택지(보기)의 개수
	@Getter @Setter
	private int polltotal;	//이 질문에 투표한 사람의 수
	
	@Getter @Setter
	private Date regdate;	//등록일
	
	private boolean vote;	//투표를 했는지 안했는지 여부를 걸러주는 변수
	
	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}
	
	@Builder
	public PollDto() { }

	/** 선택지를 보여주기 위한 생성자
	 * @param id
	 * @param question
	 * @param itemcount
	 */
	@Builder
	public PollDto(String id, String question, int itemcount) {
		super();
		this.id = id;
		this.question = question;
		this.itemcount = itemcount;
	}

	/**투표를 등록할 때 필요한 생성자
	 * @param id
	 * @param question
	 * @param sdate
	 * @param edate
	 * @param itemcount
	 * @param polltotal
	 */
	@Builder
	public PollDto(String id, String question, Date sdate, Date edate, int itemcount, int polltotal) {
		super();
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
	}
	
	/**All Args Constructor
	 * @param pollid
	 * @param id
	 * @param question
	 * @param sdate
	 * @param edate
	 * @param itemcount
	 * @param polltotal
	 * @param regdate
	 */
	@Builder
	public PollDto(int pollid, String id, String question, Date sdate, Date edate, int itemcount, int polltotal,
			Date regdate, boolean vote) {
		super();
		this.pollid = pollid;
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
		this.regdate = regdate;
		this.vote = vote;
	}	
}
