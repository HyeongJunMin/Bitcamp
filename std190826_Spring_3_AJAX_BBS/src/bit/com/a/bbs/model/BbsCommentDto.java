package bit.com.a.bbs.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE BBS190729_COMMENT(
	    SEQ NUMBER(5) NOT NULL PRIMARY KEY,
	    PARENT NUMBER(5),
	    LIKECNT NUMBER(5),
	    REF NUMBER(5),
	    STEP NUMBER(5),
	    DEPTH NUMBER(5),
	    DEL NUMBER(5),
	    ID VARCHAR2(400),
	    CONTENT VARCHAR2(4000),
	    WDATE DATE DEFAULT SYSDATE
	);
CREATE SEQUENCE SEQ_BBS190729_COMMENT START WITH 1 MAXVALUE 9999999999 INCREMENT BY 1;
*/

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BbsCommentDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int seq;
	private int parent;
	private int likecnt;
	private int ref;
	private int step;
	private int depth;
	private int del;
	private String id;
	private String content;
	private String wdate;
	
	@Builder
	public BbsCommentDto(int parent, int ref, int step, int depth, String id, String content) {
		super();
		this.parent = parent;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.id = id;
		this.content = content;
	}

	@Builder
	public BbsCommentDto(int seq, int parent, int likecnt, int ref, int step, int depth, int del, String id,
			String content, String wdate) {
		super();
		this.seq = seq;
		this.parent = parent;
		this.likecnt = likecnt;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.del = del;
		this.id = id;
		this.content = content;
		this.wdate = wdate;
	}	
}
