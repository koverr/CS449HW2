package problem5;

import java.util.ArrayList;

abstract public class Sale5 {
	
	private ArrayList<Item5> itemList = new ArrayList<Item5>();
	
	public void addItem(Item5 item) {
		itemList.add(item);
	}
	
	public abstract double getDiscountRate();  
	 
	public double getDiscount(){   
		double discount = getSubTotal() * getDiscountRate();
		return discount >= 0 ? discount : 0;
	}  
	 
	public double getSubTotal() { 
		double subTotal = 0.0; 
		double itemTotal = 0;
		int itemCode = 0;
		for (Item5 item : itemList) {  
			itemTotal = item.getItemTotal();
			itemCode = item.getSpecialItemCode();
			
			// Discounts the total of special items by 50% when there's more than 1
			if (itemCode != 0) {
				itemTotal += ((itemTotal * (item.getQuantity()-1)) * 0.5);
			}
			else {
				itemTotal += (itemTotal * (item.getQuantity()-1));
			}
			
	 		subTotal += (itemTotal >= 0 ? itemTotal : 0);
	 	}  
		return subTotal;  
	}    
	 
	public double getDiscountedSubTotal() {   
		return getSubTotal() - getDiscount(); 
	} 
	
}
