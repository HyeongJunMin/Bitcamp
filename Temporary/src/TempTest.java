import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;


public class TempTest {
	public static void main(String[] args) {
		Integer str = 123;
		CallTest a = new CallTest();
		System.out.println(a.re(str) + "  " + str);
		
		int[] d = {1,2,3,4,5};
		
		List<Integer> lst = new ArrayList<>();
		
		lst = IntStream.of(d).boxed().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(lst.toString());
	}
}
