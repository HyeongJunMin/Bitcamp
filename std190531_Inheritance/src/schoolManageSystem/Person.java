package schoolManageSystem;

import java.time.LocalDate;

public class Person {
	private int num; 	//학사 관리를 위한 고유 번호
	private String name;	//이름
	private LocalDate adMissionTime;	//입학년도
	private String major;	//전공과목
	private String college;	//단과대학이름
	private static int accNumberOfStudent;	//총 학생 숫자
	private static int accNumberOfTeacher;	//총 선생 숫자
	
	public Person() {	}
	
	public Person(int num, String name, LocalDate adMissionTime, String major, String college) {

		this.num = num;
		this.name = name;
		this.adMissionTime = adMissionTime;
		this.major = major;
		this.college = college;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getAdMissionTime() {
		return adMissionTime;
	}

	public void setAdMissionTime(LocalDate adMissionTime) {
		this.adMissionTime = adMissionTime;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public static int getAccNumberOfStudent() {
		return accNumberOfStudent;
	}

	public static void setAccNumberOfStudent(int accNumberOfStudent) {
		Person.accNumberOfStudent = accNumberOfStudent;
	}

	public static int getAccNumberOfTeacher() {
		return accNumberOfTeacher;
	}

	public static void setAccNumberOfTeacher(int accNumberOfTeacher) {
		Person.accNumberOfTeacher = accNumberOfTeacher;
	}


}
