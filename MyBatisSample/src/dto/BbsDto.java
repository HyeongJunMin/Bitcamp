package dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BbsDto implements Serializable{
	private int seq;
	private String id;
	private String title;
	
	private String content;
	private Date wdate;
	private int del;
	private int readcount;
}
