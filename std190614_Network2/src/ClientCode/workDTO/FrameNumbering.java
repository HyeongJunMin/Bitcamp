package workDTO;

import java.io.Serializable;

public class FrameNumbering implements Serializable {
	public static int num = 0;
	
	public FrameNumbering () {
		num++;
	}
}
