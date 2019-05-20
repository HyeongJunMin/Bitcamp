package std190520_Lambda;

import java.util.List;

public class Car {
	public String name;
	public int capacity;
	public int price;
	public int age;
	
	public Car(String name, int capacity, int price, int age) {
		this.name = name;
		this.capacity = capacity;
		this.price = price;
		this.age = age;
	}
	
	public String toString() {
		return name;
	}
	
	public static void printCarCheaperThan(List<Car> cars, int price) {
		for(Car car : cars) {
			if(car.price < price) {
				System.out.println(car);
			}
		}
	}
	
	public static void printCar(List<Car> cars, CheckCar tester) {
		for(Car car : cars) {
			if(tester.test(car)) {
				System.out.println(car);
			}
		}
	}
}
/*
  	실습1
  	내부클래스, 익명클래스, 람다를 왜 사용하는지 자바를 처음 시작할 때는 이해하기 어려울 수 있습니다. 
  	지금은 예제를 보면서 저렇게도 쓸 수 있구나! 정도로 이해하면 됩니다. 
  	내부클래스, 익명클래스, 람다를 이용해서 같은 작업을 어떻게 다르게 할 수 있는지 살펴보면서 
  	각각이 어떻게 쓰이는지 눈여겨보세요.
  
  	다음 코드는 앞으로 예제에서 사용할 Car클래스입니다. 
  	다음 예제로 이동하려면 실행 버튼을 누르세요.

	실습2
	main에서는 다양한 조건의 Car객체를 만들어서 
	cars라는 리스트에 넣습니다. 
	
	이 cars라는 리스트에 있는 차를 검색해서 
	조건에 맞는 차를 출력하는 예제들을 살펴볼 텐데요. 
	첫 번째로 가격이 2000보다 싼 차량을 검색해서 
	이름을 출력하는 printCarCheaperThan이라는 함수가 있습니다.
	코드를 확인하고 [실행]해서 결과를 확인하세요. 
	[제출]하면 다음 문제로 이동합니다.
	
	실습3
	이번에는 조건이 더 복잡한 경우입니다. 
	내부클래스를 이용해서 CheckCar라는 인터페이스를 만들고, 
	그걸 구현하는 CheckCarForBigAndNotExpensive클래스를 만들어서 
	4명 이상이 탈 수 있고, 가격이 2500이하인 차를 검색합니다.
	[실행]해 보고 결과를 확인하세요. 
	[제출]하면 다음 문제로 이동합니다.
	
*/