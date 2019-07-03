package coffeeOrder_6_DTO;

public class DTOCfMenu {
	private int seq;
	private String name;
	private String priceShort;
	private String priceTall;
	private String priceGrande;
	
	public DTOCfMenu() {	}
	
	public DTOCfMenu(int seq, String name, String priceShort, String priceTall, String priceGrande) {
		super();
		this.seq = seq;
		this.name = name;
		this.priceShort = priceShort;
		this.priceTall = priceTall;
		this.priceGrande = priceGrande;
	}
	
	public int getSeq() {		
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPriceShort() {
		return priceShort;
	}
	public void setPriceShort(String priceShort) {
		this.priceShort = priceShort;
	}
	public String getPriceTall() {
		return priceTall;
	}
	public void setPriceTall(String priceTall) {
		this.priceTall = priceTall;
	}
	public String getPriceGrande() {
		return priceGrande;
	}
	public void setPriceGrande(String priceGrande) {
		this.priceGrande = priceGrande;
	}

	@Override
	public String toString() {
		return "DTOCfMenu [seq=" + seq + ", name=" + name + ", priceShort=" + priceShort + ", priceTall=" + priceTall
				+ ", priceGrande=" + priceGrande + "]";
	}
	
}
