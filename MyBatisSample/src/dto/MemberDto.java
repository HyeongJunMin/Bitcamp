package dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto implements Serializable {
	private String id;
	private String pw;
	private String email;
	
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", email=" + email + "]";
	}	
}


/*
 * CREATE TABLE MEMBERDTO( 
 * ID VARCHAR2(50) PRIMARY KEY, 
 * PW VARCHAR2(50) NOT NULL, 
 * EMAIL VARCHAR2(50) NOT NULL 
 * );
 */