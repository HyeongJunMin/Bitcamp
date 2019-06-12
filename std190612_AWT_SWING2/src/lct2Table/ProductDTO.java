package lct2Table;

public class ProductDTO {
	private int seq;	//상품번호
	private String name; //상품 이름
	private int price; //상품 가격
	private String company; //회사이름
	
	public ProductDTO() {  }

	public ProductDTO(int seq, String name, int price, String company) {
		this.seq = seq;
		this.name = name;
		this.price = price;
		this.company = company;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "ProductDTO [seq=" + seq + ", name=" + name + ", price=" + price + ", company=" + company + "]";
	}
	
}
