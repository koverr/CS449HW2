package problem2;

import java.util.ArrayList;

import problem1.Item1;

public class Sale2 {
	
	private static final String SENIOR_CUSTOMER = "Senior";
	private static final String PREFERRED_CUSTOMER = "Preferred";
	
	private static final double DISCOUNT_RATE = 0.05;
	private static final double DISCOUNT_RATE_SENIOR = 0.1;
	private static final double DISCOUNT_RATE_PREFERRED = 0.15;
	
	private ArrayList<Item1> itemList = new ArrayList<Item1>();
	
	private String customerType = new String();
	
	public String getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	public void addItem(Item1 item) {
		itemList.add(item);
	}
	
	public double getDiscountRate() {   
		double discount = DISCOUNT_RATE;
		switch(customerType) {
		case SENIOR_CUSTOMER:
			discount += DISCOUNT_RATE_SENIOR;
			break;
			
		case PREFERRED_CUSTOMER:
			discount += DISCOUNT_RATE_PREFERRED;
			break;
		}
		return discount;
	}  
	 
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
