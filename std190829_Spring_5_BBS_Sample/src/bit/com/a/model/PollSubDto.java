package bit.com.a.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**투표 기능에서 선택지에 관련된 내용을 담는 DTO
 * @author minhj
 *
 */
@Getter
@Setter
@ToString
public class PollSubDto implements Serializable {
	
	private int pollsubid;	//sequence
	private int pollid;		//주제(poll)의 sequence
	private String answer;	//선택지의 이름
	private int acount;		//선택지를 선택한 사람의 총 수
	
	/**No Args Constructor
	 * 
	 */
	@Builder
	public PollSubDto() {	}

	/**All Args Constructor
	 * @param pollsubid
	 * @param pollid
	 * @param answer
	 * @param acount
	 */
	@Builder
	public PollSubDto(int pollsubid, int pollid, String answer, int acount) {
		super();
		this.pollsubid = pollsubid;
		this.pollid = pollid;
		this.answer = answer;
		this.acount = acount;
	}
}
