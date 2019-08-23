package bit.com.a.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto implements Serializable{
	private String id;
	private String pw;
	private String name;
	private String email;
	private int auth;
}
