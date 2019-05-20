package std190520_Lambda;

import java.util.ArrayList;
import java.util.List;

public class CarExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Car> cars = new ArrayList<>();
        cars.add( new Car("작은차",2,800,3) );
        cars.add( new Car("봉고차",12,1500,8) );
        cars.add( new Car("중간차",5,2200,0) );
        cars.add( new Car("비싼차",5,3500,1) );
        
        CarExam carExam = new CarExam();
        carExam.printCar(cars, 
        		(Car car)-> {return car.capacity >= 4 && car.price < 2500 ; }
        		);
	}
	
	
    public void printCar(List<Car> cars, CheckCar tester){
        for(Car car : cars){
            if (tester.test(car)) {
                System.out.println(car);
            }
        }
    }
    
    interface CheckCar{
        boolean test(Car car);
    }  

}
