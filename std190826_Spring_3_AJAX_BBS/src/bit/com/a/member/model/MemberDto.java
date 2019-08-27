package bit.com.a.member.model;

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
	

	/**로그인에 사용되는 생성자
	 * @param id
	 * @param pw
	 */
	public MemberDto(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
}
