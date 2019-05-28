package std190528_Object_Calendar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Lct1Calendar {
	/*
	  	��¥�� Ȱ���� �� �ִ� Ŭ������ Calendar, Data ���� �ִ�
	  	�ַ� Calendar�� Ȱ���Ѵ�. Data�� ���� ������
	  	
	  	�� ���ó : ���� �ý���
	*/
	
	public static void aboutTimeClass() {
		//Time Ŭ���� Ȱ��
		int year = 0;
		int mon = 0;
		int day = 0;
		
		//���� ��-��-�� Ȯ��
		LocalDate currentDate = LocalDate.now();
		year = currentDate.getYear();
		mon = currentDate.getMonthValue();
		day = currentDate.getDayOfMonth();
		System.out.println(year + " " + mon + " " + day);
		System.out.println(year + " " + currentDate.getMonth() + " " + day);
		
		//������ ��¥�� ��-��-�� Ȯ��
		LocalDate targetDate = LocalDate.of(1991, 2, 18);
		System.out.println(targetDate.getYear() + " " + targetDate.getMonth() + " " + targetDate.getDayOfMonth());
		
		//���� �ð���ü ����
		LocalTime crtTime = LocalTime.now();
		LocalTime trgTime = LocalTime.of(12, 30, 34, 33); //��, ��, ��, ������
		
	}
	
	
	public static void main(String[] args) {
		//Ķ���� ���� ��� 1
		Calendar cal2 = new GregorianCalendar(); cal2.clear();
		//Ķ���� ���� ��� 2
		Calendar cal = Calendar.getInstance();
		
		//��¥ ��� - ��¥�� �Ҽ����� ������? > ���� ��
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		System.out.println( "���� : " + year + "-0" + mon + "-" + day);
		
		//��¥ ���� == setter
		cal.set(Calendar.YEAR, 1991);
		cal.set(Calendar.MONTH, 2 - 1);
		cal.set(Calendar.DATE, 18);
		System.out.println( "���� : " + cal.get(Calendar.YEAR) + "-0" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE));
		
		cal = Calendar.getInstance();
		//������ 0, ���Ĵ� 1
		String ampm = cal.get(Calendar.AM_PM)==0?"����":"����";
		System.out.println(ampm);
		
		//���� : �Ͽ��� �������� 1���� ����(���� 0�ƴ�)
		int weekDay = cal.get(Calendar.DAY_OF_WEEK);
		String wdn = "";
		switch( weekDay ) {
			case 1 : wdn="��"; break;
			case 2 : wdn="��"; break;
			case 3 : wdn="ȭ"; break;
			case 4 : wdn="��"; break;
			case 5 : wdn="��"; break;
			case 6 : wdn="��"; break;
			case 7 : wdn="��"; break;
			default : wdn="?"; break;
		}
		System.out.println("���� : " + wdn + " " +weekDay);
		
		//������ ���� ������ ��¥�� ����ϴ� ���
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("���� ������ ��¥ : " + lastDay);
		cal.set(Calendar.MONTH, 2 - 1);
		System.out.println("2�� ������ ��¥ : " + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal = Calendar.getInstance();
		
		//��-��-���� �����ϸ�, �޷��� �� ĭ�� �� �� �ִ��� ���
		year = 2020;
		mon = 2;
		day = 1;
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, mon - 1);
		cal.set(Calendar.DATE, day);
		weekDay = cal.get(Calendar.DAY_OF_WEEK);//������������ Ȯ��
		
		int emptySpace = (weekDay - 1) % 7;//����-1 = �� ĭ ����
		
		System.out.println("������ ��ĭ : " + emptySpace + "ĭ");
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DATE, lastDay);
		weekDay = cal.get(Calendar.DAY_OF_WEEK);
		
		int emptySpace2 = 7 - weekDay;
		System.out.println("�Ʒ����� ��ĭ : " + emptySpace2 + "ĭ");
		
		aboutTimeClass();
	}
}
