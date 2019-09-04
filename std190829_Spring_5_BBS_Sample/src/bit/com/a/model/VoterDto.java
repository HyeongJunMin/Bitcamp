package bit.com.a.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**	투표 기능에서 투표자에 대한 정보를 담기위한 DTO
 * @author minhj
 *
 */
@Getter
@Setter
@ToString
public class VoterDto implements Serializable {
	private int voterid;	//현재 DTO의 seq
	private int pollid;		//주제 id
	private int pollsubid;	//선택지 id
	private String id;		//투표자 id
	private Date regdate;	//투표시점
	
	/** No Args Cns
	 * 
	 */
	@Builder
	public VoterDto() { }

	/** All Args Cns
	 * @param voterid
	 * @param pollid
	 * @param pollsubid
	 * @param id
	 * @param regdate
	 */
	@Builder
	public VoterDto(int voterid, int pollid, int pollsubid, String id, Date regdate) {
		super();
		this.voterid = voterid;
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;
		this.regdate = regdate;
	}

	@Builder
	public VoterDto(int pollid, int pollsubid, String id) {
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;
	}
}
