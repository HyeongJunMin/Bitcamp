package coffeeOrder_6_DTO;

public class DTOOrderedMenu {
	private String customerName;
	private String menuName;
	private String size;
	private String syrup;
	private String shot;
	private String whip;
	private int amount;
	
	public DTOOrderedMenu() {}
	
	public DTOOrderedMenu(String customerName, String menuName, String size, String syrup, String shot, String whip,
			int amount) {
		super();
		this.customerName = customerName;
		this.menuName = menuName;
		this.size = size;
		this.syrup = syrup;
		this.shot = shot;
		this.whip = whip;
		this.amount = amount;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSyrup() {
		return syrup;
	}
	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}
	public String getShot() {
		return shot;
	}
	public void setShot(String shot) {
		this.shot = shot;
	}
	public String getWhip() {
		return whip;
	}
	public void setWhip(String whip) {
		this.whip = whip;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DTOOrderedMenu [customerName=" + customerName + ", menuName=" + menuName + ", size=" + size + ", syrup="
				+ syrup + ", shot=" + shot + ", whip=" + whip + ", amount=" + amount + "]";
	}
	
}
