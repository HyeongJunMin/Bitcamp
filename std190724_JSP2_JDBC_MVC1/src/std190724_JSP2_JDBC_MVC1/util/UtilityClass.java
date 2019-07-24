package std190724_JSP2_JDBC_MVC1.util;

public class UtilityClass {
	public static boolean has$(String msg){
		return msg.contains("$");//$문자를 포함하는 임시테이블을 구분하기 위함
	}
}
