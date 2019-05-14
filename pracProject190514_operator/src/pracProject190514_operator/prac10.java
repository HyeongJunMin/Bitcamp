package pracProject190514_operator;
import java.util.*;
public class prac10 {
	//10,000원을 받앋을 때 잔돈 화폐 별 갯수를 구하세요
	int arr[] = {5000,1000,500,100,50,10};
	int cnt=0;
	int income=10000,price=3420,exchange=income-price;
	void cal() {
		System.out.println("");
		for(int i:arr) {
			cnt=exchange/i;
			System.out.println(i+"원 : "+cnt+"개");
			exchange %= i; 
		}
	}
}
