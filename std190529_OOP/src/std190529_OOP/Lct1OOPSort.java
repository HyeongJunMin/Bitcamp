package std190529_OOP;

import java.util.Arrays;

import BaseballGame.BaseballGameClass;
import BlackjackGame.Blackjack;
import SortMain.SortClass;

public class Lct1OOPSort {
	public static void main(String[] args) {
		
//		int[] arr = {2,6,3,21,3,6,78};
//		System.out.println("배열 : " + Arrays.toString(arr));
//		SortClass s = new SortClass();
//		
//		arr = s.sortIntegerArray(arr, 1);
//		System.out.println("배열 : " + Arrays.toString(arr));
//		arr = s.sortIntegerArray(arr, 2);
//		System.out.println("배열 : " + Arrays.toString(arr));
//		arr = s.sortIntegerArray(arr);
//		System.out.println("배열 : " + Arrays.toString(arr));
//		
//		BaseballGameClass b = new BaseballGameClass();
//		b.play1();
		Blackjack b = new Blackjack();
		b.runBlackjack();
	}
}
