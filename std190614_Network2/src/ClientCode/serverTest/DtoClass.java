package serverTest;

import java.io.Serializable;

public class DtoClass implements Serializable {

	private int clientNumber;
	
	public DtoClass() {
	}

	public DtoClass(int clientNumber) {
		super();
		this.clientNumber = clientNumber;
	}

	public int getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}

	@Override
	public String toString() {
		return "DtoClass [clientNumber=" + clientNumber + "]";
	}
	
	
}
