package bit.com.a.model;

import java.io.Serializable;
import java.util.Date;

import bit.com.a.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** 투표 작성자가 작성한 투표 내용을 담는 DTO
 * @author minhj
 *
 */
@Getter
@Setter
@ToString
public class PollBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;	//작성자
	
	private int syear;	//시작년-월-일
	private int smonth;
	private int sday;
	
	private int eyear;	//종료년-월-일
	private int emonth;
	private int eday;
	
	private String question;	//투표 주제
	private int itemcount;		//선택지 개수
		
	private String poll1, poll2, poll3, poll4, poll5, poll6, poll7, poll8, poll9, poll10;
	
	private String[] pollnum = new String[10];	//선택지 내용
	
	@SuppressWarnings("unused")
	private Date sdate;	//시작 년월일 Date 형태
	@SuppressWarnings("unused")
	private Date edate;	//종료 년월일 Date 형태

	/** 선택지 내용을 문자열 배열로 리턴
	 * @return
	 */
	public String[] getPollnum() {
		pollnum[0] = DateUtil.str(poll1);
		pollnum[1] = DateUtil.str(poll2);
		pollnum[2] = DateUtil.str(poll3);
		pollnum[3] = DateUtil.str(poll4);
		pollnum[4] = DateUtil.str(poll5);
		pollnum[5] = DateUtil.str(poll6);
		pollnum[6] = DateUtil.str(poll7);
		pollnum[7] = DateUtil.str(poll8);
		pollnum[8] = DateUtil.str(poll9);
		pollnum[9] = DateUtil.str(poll10);		
		
		return pollnum;
	}
	
	/** 시작 년월일을 Date 형식으로 리턴
	 * @return
	 */
	public Date getSdate() {
		return DateUtil.toDate( getSyear() , getSmonth() , getSday() );
	}

	/** 종료 년월일을 Date 형식으로 리턴
	 * @return
	 */
	public Date getEdate() {
		return DateUtil.toDate( getEyear() , getEmonth() , getEday() );
	}

}
