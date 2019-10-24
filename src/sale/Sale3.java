package sale;

import java.util.ArrayList;

import item.Item1;

public class Sale3 {
	
	private static final String SENIOR_CUSTOMER = "Senior";
	private static final String PREFERRED_CUSTOMER = "Preferred";
	
	private static final double DISCOUNT_RATE = 0.05;
	private static final double DISCOUNT_RATE_SENIOR = 0.1;
	private static final double DISCOUNT_RATE_PREFERRED = 0.15;
	
	// Tuesday is the third day of the 7 day week (0-6 with Sunday starting at 0)
	private static final int TUESDAY = 2;
	
	private ArrayList<Item1> itemList = new ArrayList<Item1>();
	
	private String customerType = new String();
	
	private int day;
	
	public String getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void addItem(Item1 item) {
		itemList.add(item);
	}
	
	public double getDiscountRate() {   
		double discount = DISCOUNT_RATE;
		switch(customerType) {
		case SENIOR_CUSTOMER:
			discount += (day == TUESDAY ? DISCOUNT_RATE_SENIOR : 0);
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
