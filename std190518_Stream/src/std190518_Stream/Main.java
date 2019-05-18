package std190518_Stream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Stream 'forEach, limit' method");
				
		Random ran = new Random();
		ran.ints().limit(10).forEach(System.out::println);
		
		
		System.out.println("Stream 'sorted' method");
		
		ran.ints().limit(10).sorted().forEach(System.out::println);
		
		
		System.out.println("Stream 'map' method");
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		 		//get list of unique squares
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		squaresList.forEach(System.out::println);
		
		
		System.out.println("Stream 'filter' method");
		
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		 
		//get count of empty string
		int count = (int) strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println(count);
		
		
		System.out.println("Stream 'parallelStream' method");
		
		strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		//get count of empty string
		count = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println(count);
		
		
		System.out.println("Stream 'Collectors'");
		
		strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
	}
}
