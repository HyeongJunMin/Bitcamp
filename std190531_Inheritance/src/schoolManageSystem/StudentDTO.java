package schoolManageSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO extends Person{
	// Data Transfer Object
	// 객체 별 데이터 관리 클래스
	private int yearGrade;	//학년 정보
	private int korScore;	//국어 점수
	private int engScore;	//영어 점수
	private int mthScore;	//수학 점수
	private List<Double> lst = new ArrayList<>();

}
