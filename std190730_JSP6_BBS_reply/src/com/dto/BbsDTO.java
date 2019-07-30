package com.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsDTO implements Serializable{
	private int seq;
	private String id;	//작성자
	
	private int ref;	//그룹 번호
	private int step;	//행 번호
	private int depth;//깊이
	
	private String title;
	private String content;
	private String wdate;
	private int parent;	//부모글 번호
	
	private int del;
	private int readcount;	//조회 수
	
	//3개만 받는 생성자(새 글 저장 용도)
	public BbsDTO(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	//3개만 받는 생성자(글 수정 용도)
	public BbsDTO(int seq, String title, String content) {
		this.seq = seq;
		this.title = title;
		this.content = content;
	}
	
	public String toJson() {
		String json = "";
		
		json += "{";
		json += "\"seq\":\"" + seq + "\"";
		json += ",\"id\":\"" + id + "\"";	//작성자
		
		json += ",\"ref\":\"" + ref + "\"";	//그룹 번호
		json += ",\"step\":\"" + step + "\"";	//행 번호
		json += ",\"depth\":\"" + depth + "\"";//깊이
		
		json += ",\"title\":\"" + title + "\"";
		//json += ",\"content\":\"" + content + "\"";
		//json += ",\"content\":\"" + content.replace("\n", "\\r\\n") + "\"";
		//json += ",\"content\":\"" + content.replace("\n", "<br>") + "\"";
		json += ",\"content\":\"" + content.replace("\\r\\n", "\n") + "\"";
		json += ",\"wdate\":\"" + wdate + "\"";
		json += ",\"parent\":\"" + parent + "\"";	//부모글 번호
		
		json += ",\"del\":\"" + del + "\"";
		json += ",\"readcount\":\"" + readcount + "\"";	//조회 수
		json += "}";
		
		return json;
	}
}
