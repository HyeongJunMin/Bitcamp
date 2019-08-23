package dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsParam implements Serializable {
	private String keyword;//검색어
	private String content;
	private String s_category;//제목, 내용, 작성자	
}
