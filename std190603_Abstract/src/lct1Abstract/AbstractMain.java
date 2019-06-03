package lct1Abstract;

public class AbstractMain {
	public static void main(String[] args) {
		
		
		AbstractClass ab = new AbstractClass() {
			
			@Override
			public void abstractMethod() {
				// TODO Auto-generated method stub
				
			}
		};
		
//		AInterface a = new AInterface() {
//			
//			@Override
//			public void method1() {
//				// TODO Auto-generated method stub
//				
//			} 
//		};
		
		AClass ac = new AClass();
		ac.method1();
		
	
	}
}
