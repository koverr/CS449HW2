package sale;

import java.util.ArrayList;

import item.Item1;

abstract public class Sale4 {
	
	private ArrayList<Item1> itemList = new ArrayList<Item1>();
	
	public void addItem(Item1 item) {
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
		for (Item1 item : itemList) {  
			itemTotal = item.getItemTotal();
	 		subTotal += (itemTotal >= 0 ? itemTotal : 0);
	 	}  
		return subTotal;  
	}    
	 
	public double getDiscountedSubTotal() {   
		return getSubTotal() - getDiscount(); 
	} 
	
}
