package std190521_sort;

import java.util.Scanner;

public class JudgeInput {
	Scanner in = new Scanner(System.in);
	String intro = "Y 또는 N을 입력해주세요.";
	String trueResultString = "입력값 :";
	String falseResultString = "잘못 입력하셨습니다. 다시 입력하세요.";
	String inputForJudge = "";
	
	void setIntro(String a) {
		this.intro = a;
	}
	void setTrueResultString(String a) {
		this.trueResultString = a;
	}
	void setFalseResultString(String a) {
		this.falseResultString = a;
	}
	
	char inputRightString(){
		//입력값이 Y, N이면 입력값 리턴
		boolean judgeIsRight = false;
		Scanner in = new Scanner(System.in);
		char isYOrN = ' ';
						
		int w = 0;
		while(w < 5) {			
			System.out.println(intro);
			inputForJudge = in.next();
			
			if(!isContainYOrN(inputForJudge)) {
				
				judgeIsRight = true;
				isYOrN = inputForJudge.charAt(0);
				break;
			} else {
				System.out.println(falseResultString);
				judgeIsRight = false;
			}
			w++;
			if(w == 5) {
				judgeIsRight = false;
			}			
		}
		
		return isYOrN;
	}
	
	boolean inputRightRange(int a, int b){
		boolean judgeIsRight = false;
		Scanner in = new Scanner(System.in);
						
		int w = 0;
		while(w < 5) {			
			System.out.println(intro);
			inputForJudge = in.next();
			
			if(isContainNumber(inputForJudge , a, b)) {
				System.out.println(trueResultString + inputForJudge);
				judgeIsRight = true;
				break;
			} else {
				System.out.println(falseResultString);
				judgeIsRight = false;
			}
			w++;
			if(w == 5) {
				judgeIsRight = false;
			}			
		}
		
		return judgeIsRight;
	}
	
	//판단 메서드
	boolean isContainNumber(String strIn, int min, int max) {
        // 입력받은 문자열 strIn이 정수인지 판별하고
        // 정수인 경우 min값 이상 max값 이하이면 true 리턴
        boolean isThat = true;
        try {
            int num = Integer.parseInt(strIn);
            if (num < min || num > max) {
                isThat = false;
            } else {
                isThat = true;
            }
 
        } catch (NumberFormatException e) {
            isThat = false;
        }
 
        return isThat;
    }// 메서드 중괄호
	boolean isContainYOrN(String strIn) {
        // 입력받은 문자열 strIn의 첫 글자가 Y 또는 N인지 확인
        boolean isThat = true;
        try {
            char chInYOrN = strIn.toUpperCase().charAt(0);
            if (chInYOrN == 'Y'  || chInYOrN == 'N') {
                isThat = false;
            } else {
                isThat = true;
            }
 
        } catch (NumberFormatException e) {
            isThat = false;
        }
 
        return isThat;
    }// 메서드 중괄호
}
