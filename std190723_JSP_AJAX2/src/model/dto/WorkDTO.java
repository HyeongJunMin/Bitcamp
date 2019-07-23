package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkDTO {
	private String id;
	private String pw;
	private String[] hobby;
	private String age;
	private String txt;
}
