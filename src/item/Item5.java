package item;

public class Item5 {
	
	private String title;
	private double itemTotal;
	private int quantity;
	// If the item has a special discount it will have a code
	// If the item does not have a special disount the code will be 0
	private int specialItemCode = 0;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getItemTotal() {
		return itemTotal;
	}
	
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSpecialItemCode() {
		return specialItemCode;
	}

	public void setSpecialItemCode(int specialItemCode) {
		this.specialItemCode = specialItemCode;
	}

	
}
