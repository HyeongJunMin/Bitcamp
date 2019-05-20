package std190520_Lambda;

import java.util.ArrayList;
import java.util.List;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

public class Main {
	public static void main(String[] args) {
		Car car = new Car("new model", 4, 3000, 0);
		
		List<Car> cars = new ArrayList<>();
		
		cars.add( new Car("작은차", 2, 800, 3) );
		cars.add( new Car("봉고차", 12, 1500, 8) );
		cars.add( new Car("중간차", 5, 2200, 0) );
		cars.add( new Car("비싼차", 5, 3500, 1) );
		
		car.printCarCheaperThan(cars, 2000);
		
		printCar(cars, new CheckCarForBigAndNotExpensive());
		
		printCar(cars, 
				new CheckCar() {
				public boolean test(Car car) {
					return car.capacity >= 4 && car.price < 2500;
				}
		});
	}
	
    interface CheckCar{
        boolean test(Car car);
    }
    
    //내부클래스를 만들어서 사용합니다.
    static class CheckCarForBigAndNotExpensive implements CheckCar{
        public boolean test(Car car){
            return car.capacity >= 4 && car.price < 2500;
        }
    }
    
    public static void printCarCheaperThan(List<Car> cars, int price) {
		for(Car car : cars) {
			if(car.price < price) {
				System.out.println(car);
			}
		}
	}
    public static void printCar(List<Car> cars, CheckCar tester){
        for(Car car : cars){
            if (tester.test(car)) {
                System.out.println(car);
            }
        }
    }
    
}

