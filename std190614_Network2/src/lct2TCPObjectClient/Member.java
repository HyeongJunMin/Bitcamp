package lct2TCPObjectClient;

import java.io.Serializable;

public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 240217886626946782L;
	
	private String name;
	private double height;
	
	public Member() {}
	
	public Member(String name, double height) {
		super();
		this.name = name;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", height=" + height + "]";
	}
	
	
}
