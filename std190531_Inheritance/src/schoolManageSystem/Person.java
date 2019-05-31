package schoolManageSystem;

import java.time.LocalDate;

public class Person {
	private int num; 	//�л� ������ ���� ���� ��ȣ
	private String name;	//�̸�
	private LocalDate adMissionTime;	//���г⵵
	private String major;	//��������
	private String college;	//�ܰ������̸�
	private static int accNumberOfStudent;	//�� �л� ����
	private static int accNumberOfTeacher;	//�� ���� ����
	
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
