package std190722_Servlet2_AJAX.lct1Servlet2;

public class MemberVO {
	private String inputId;
	private String inputPw;
	
	public MemberVO(String inputId, String inputPw) {
		super();
		this.inputId = inputId;
		this.inputPw = inputPw;
	}
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public String getInputId() {
		return inputId;
	}
	public void setInputId(String inputId) {
		this.inputId = inputId;
	}
	public String getInputPw() {
		return inputPw;
	}
	public void setInputPw(String inputPw) {
		this.inputPw = inputPw;
	}
}
