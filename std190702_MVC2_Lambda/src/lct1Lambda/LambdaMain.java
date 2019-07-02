package lct1Lambda;

import java.util.Comparator;

public class LambdaMain {
	public static void main(String[] args) {

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
		
		
		
//		//Classical way
//		List<String> strs = Arrays.asList( "tiger", "bear", "liom" );
//		strs.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//		});
//		
//		//Lambda way
//		List<String> strs2 = Arrays.asList( "tiger", "bear", "liom" );
//		Consumer<String> cons = str->System.out.println(str);
//		strs.forEach(cons);
		
		
		//단순한 인터페이스
//		Consumer<String> cons = new Consumer<String>() {
//			@Override
//			public void accept(String str) {
//				// TODO Auto-generated method stub
//				System.out.println(str);
//			}
//		};
//		
//		String str = "Classical way";		
//		cons.accept(str);				
//		
//		Consumer<String> cons2 = (str2)->{ System.out.println(str2); };
//		cons2.accept("Lambda way");
	}
}
