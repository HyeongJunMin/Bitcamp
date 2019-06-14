package workDTO;

import java.io.Serializable;

public class RSPDTO implements Serializable{
	private int inputNum;
	
	public RSPDTO() {
		
	}
	public RSPDTO(int in) {
		this.inputNum = in;
	}
	public int getInputNum() {
		return inputNum;
	}
	public void setInputNum(int inputNum) {
		this.inputNum = inputNum;
	}
}