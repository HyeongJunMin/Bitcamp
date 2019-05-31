package work3Instanceof;

public class RobotMain {
	public static void action(Robot r) {
		if( r instanceof DanceRobot ) {
			DanceRobot d = (DanceRobot) r;
			d.dance();
		} else if(r instanceof SingRobot ) {
			SingRobot d = (SingRobot) r;
			d.sing();
		} else {
			DrawRobot d = (DrawRobot) r;
			d.draw();
		}
	}
	public static void main(String[] args) {
		Robot[] arr = { new DanceRobot(), new SingRobot(), 
				new DrawRobot()};
			for(int i=0; i< arr.length;i++)
				action(arr[i]);
	}
}
