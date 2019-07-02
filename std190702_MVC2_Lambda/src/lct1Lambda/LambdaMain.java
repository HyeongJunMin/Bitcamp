package lct1Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class LambdaMain {
	
	public static int b = 0;
	
	public static void main(String[] args) {		
		LambdaMain.ex6();
	}
	
	public static void ex6() {
		IntStream.range(0, 10).forEach(i->System.out.println(i));
	}
	
	public static void ex5() {
		List<Integer> arrLst = Arrays.asList(1,2,3,4,5);
		arrLst.forEach(a -> b += a );
		System.out.println(b);
		//람다식 내부에 들어갈 수 있는 외부의 변수는 static뿐
	}
	
	public static void ex4() {
		//Classical way
		List<String> arrLst = Arrays.asList("a","b","c");
		StringBuilder builder = new StringBuilder();
		for(String s : arrLst) {
			builder.append(s);
		}
		System.out.println(builder.toString());
		
		//Lambda way
		StringBuilder builder2 = new StringBuilder();
		arrLst.forEach(s -> builder2.append(s));
		System.out.println(builder2);
	}
	
	public static void ex3() {
		//Classical way
		Comparator<Integer> com1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 * o2;
			}
		};		
		System.out.println("r : " + com1.compare(5, 10) );
		
		//Lambda way
		Comparator<Integer> com2 = (a, b)-> a * b;
		System.out.println("r : " + com2.compare(5, 10));
	}
	
	public static void ex2() {
		//Classical way
		List<String> strs = Arrays.asList( "tiger", "bear", "liom" );
		strs.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		//Lambda way
		List<String> strs2 = Arrays.asList( "tiger", "bear", "liom" );
		Consumer<String> cons = str->System.out.println(str);
		strs.forEach(cons);
	}
	
	public static void ex1() {
		//단순한 인터페이스
		Consumer<String> cons = new Consumer<String>() {
			@Override
			public void accept(String str) {
				// TODO Auto-generated method stub
				System.out.println(str);
			}
		};
		
		String str = "Classical way";		
		cons.accept(str);				
		
		Consumer<String> cons2 = (str2)->{ System.out.println(str2); };
		cons2.accept("Lambda way");
	}
}
