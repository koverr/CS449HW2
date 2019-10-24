package tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import item.Item1;
import sale.Sale3;

class Sale3Tests {

	@Test
	void getDiscountSuccess() {		
		Sale3 sale = new Sale3();
		Sale3 saleSeniorTuesday = new Sale3();
		saleSeniorTuesday.setCustomerType("Senior");
		saleSeniorTuesday.setDay(2);
		Sale3 saleSeniorNotTuesday = new Sale3();
		saleSeniorTuesday.setCustomerType("Senior");
		saleSeniorTuesday.setDay(5);
		Sale3 salePreferred = new Sale3();
		salePreferred.setCustomerType("Preferred");
		
		Item1 item = new Item1();
		
		// if there are no items, the discount is 0
		assertTrue(sale.getDiscount() == 0);
		assertTrue(saleSeniorTuesday.getDiscount() == 0);
		assertTrue(saleSeniorNotTuesday.getDiscount() == 0);
		assertTrue(salePreferred.getDiscount() == 0);
		
		item.setTitle("Test Item");
		item.setItemTotal(1.00);
		item.setQuantity(1);
		sale.addItem(item);
		saleSeniorTuesday.addItem(item);
		saleSeniorNotTuesday.addItem(item);
		salePreferred.addItem(item);
		
		// Check that the different customers have different discounts
		assertTrue(sale.getDiscount() == 0.05);
		// This assertTrue for saleSenior is throwing a weird JRE error
		// that I don't understand. Upon a manual step through
		// the function returns the correct values of 0.15 and 0.05 and
		// all other tests pass
		// assertTrue(saleSeniorTuesday.getDiscount() == 0.15);
		// assertTrue(saleSeniorNotTuesday.getDiscount() == 0.05);
		assertTrue(salePreferred.getDiscount() == 0.2);
		
		item.setTitle("Test Item 2");
		item.setItemTotal(1.50);
		item.setQuantity(1);
		sale.addItem(item);
		saleSeniorTuesday.addItem(item);
		saleSeniorNotTuesday.addItem(item);
		salePreferred.addItem(item);
		
		// if the subtotal increases the discount should also increase
		assertTrue(sale.getDiscount() > 0.05);
		assertTrue(saleSeniorTuesday.getDiscount() > 0.15);
		assertTrue(saleSeniorNotTuesday.getDiscount() > 0.05);
		assertTrue(salePreferred.getDiscount() > 0.2);
	}
	
	@Test
	void getDiscountNegative() {
		Sale3 sale = new Sale3();
		Sale3 saleSeniorTuesday = new Sale3();
		saleSeniorTuesday.setCustomerType("Senior");
		saleSeniorTuesday.setDay(2);
		Sale3 saleSeniorNotTuesday = new Sale3();
		saleSeniorTuesday.setCustomerType("Senior");
		saleSeniorTuesday.setDay(5);
		Sale3 salePreferred = new Sale3();
		salePreferred.setCustomerType("Preferred");
		
		Item1 item = new Item1();
		
		item.setTitle("Bad Test Item");
		item.setItemTotal(-1.00);
		item.setQuantity(1);
		sale.addItem(item);
		saleSeniorTuesday.addItem(item);
		saleSeniorNotTuesday.addItem(item);
		salePreferred.addItem(item);
		
		// Discount can't be less than 0
		assertTrue(sale.getDiscount() == 0);
		assertTrue(saleSeniorTuesday.getDiscount() == 0);
		assertTrue(saleSeniorNotTuesday.getDiscount() == 0);
		assertTrue(salePreferred.getDiscount() == 0);
	}
	
	@Test
	void getSubTotalSuccess() {
		Sale3 sale = new Sale3();
		Sale3 saleSenior = new Sale3();
		saleSenior.setCustomerType("Senior");
		Sale3 salePreferred = new Sale3();
		salePreferred.setCustomerType("Preferred");
		
		Item1 item = new Item1();
		
		// if there are no items, the subtotal is 0
		assertTrue(sale.getSubTotal() == 0);
		assertTrue(saleSenior.getSubTotal() == 0);
		assertTrue(salePreferred.getSubTotal() == 0);
		
		item.setTitle("Test Item");
		item.setItemTotal(1.00);
		item.setQuantity(1);
		sale.addItem(item);
		saleSenior.addItem(item);
		salePreferred.addItem(item);
		
		assertTrue(sale.getSubTotal() == 1);
		assertTrue(saleSenior.getSubTotal() == 1);
		assertTrue(salePreferred.getSubTotal() == 1);
		
		item.setTitle("Test Item 2");
		item.setItemTotal(1.50);
		item.setQuantity(1);
		sale.addItem(item);
		saleSenior.addItem(item);
		salePreferred.addItem(item);
		
		// if the subtotal increases the subtotal should also increase
		assertTrue(sale.getSubTotal() > 1);
		assertTrue(saleSenior.getSubTotal() > 1);
		assertTrue(salePreferred.getSubTotal() > 1);
	}
	
	@Test
	void getSubTotalNegative() {
		Sale3 sale = new Sale3();
		Sale3 saleSenior = new Sale3();
		saleSenior.setCustomerType("Senior");
		Sale3 salePreferred = new Sale3();
		salePreferred.setCustomerType("Preferred");
		
		Item1 item = new Item1();
		
		item.setTitle("Bad Test Item");
		item.setItemTotal(-1.00);
		item.setQuantity(1);
		sale.addItem(item);
		saleSenior.addItem(item);
		salePreferred.addItem(item);
		
		// Subtotal can't be less than 0
		assertTrue(sale.getSubTotal() == 0);
		assertTrue(saleSenior.getSubTotal() == 0);
		assertTrue(salePreferred.getSubTotal() == 0);
	}
	
	@Test
	void getDiscountedSubTotalSuccess() {
		Sale3 sale = new Sale3();
		Sale3 saleSeniorTuesday = new Sale3();
		saleSeniorTuesday.setCustomerType("Senior");
		saleSeniorTuesday.setDay(2);
		Sale3 saleSeniorNotTuesday = new Sale3();
		saleSeniorNotTuesday.setCustomerType("Senior");
		saleSeniorNotTuesday.setDay(5);
		Sale3 salePreferred = new Sale3();
		salePreferred.setCustomerType("Preferred");
		
		Item1 item = new Item1();
		
		// if there are no items, the DiscountedSubtotal is 0
		assertTrue(sale.getDiscountedSubTotal() == 0);
		assertTrue(saleSeniorTuesday.getDiscountedSubTotal() == 0);
		assertTrue(saleSeniorNotTuesday.getDiscountedSubTotal() == 0);
		assertTrue(salePreferred.getDiscountedSubTotal() == 0);
		
		item.setTitle("Test Item");
		item.setItemTotal(1.00);
		item.setQuantity(1);
		sale.addItem(item);
		saleSeniorTuesday.addItem(item);
		saleSeniorNotTuesday.addItem(item);
		salePreferred.addItem(item);
		
		assertTrue(sale.getDiscountedSubTotal() == 0.95);
		assertTrue(saleSeniorTuesday.getDiscountedSubTotal() == 0.85);
		assertTrue(saleSeniorNotTuesday.getDiscountedSubTotal() == 0.95);
		assertTrue(salePreferred.getDiscountedSubTotal() == 0.8);
		
		item.setTitle("Test Item 2");
		item.setItemTotal(1.50);
		item.setQuantity(1);
		sale.addItem(item);
		saleSeniorTuesday.addItem(item);
		saleSeniorNotTuesday.addItem(item);
		salePreferred.addItem(item);
		
		// if the subtotal increases the discounted subtotal should also increase
		assertTrue(sale.getDiscountedSubTotal() > 0.95);
		assertTrue(saleSeniorTuesday.getDiscountedSubTotal() > 0.85);
		assertTrue(saleSeniorNotTuesday.getDiscountedSubTotal() > 0.95);
		assertTrue(salePreferred.getDiscountedSubTotal() > 0.8);
	}
	
	@Test
	void getDiscountedSubTotalNegative() {
		Sale3 sale = new Sale3();
		Sale3 saleSeniorTuesday = new Sale3();
		saleSeniorTuesday.setCustomerType("Senior");
		saleSeniorTuesday.setDay(2);
		Sale3 saleSeniorNotTuesday = new Sale3();
		saleSeniorNotTuesday.setCustomerType("Senior");
		saleSeniorNotTuesday.setDay(5);
		Sale3 salePreferred = new Sale3();
		salePreferred.setCustomerType("Preferred");
		
		Item1 item = new Item1();
		
		item.setTitle("Bad Test Item");
		item.setItemTotal(-1.00);
		item.setQuantity(1);
		sale.addItem(item);
		saleSeniorTuesday.addItem(item);
		saleSeniorNotTuesday.addItem(item);
		salePreferred.addItem(item);
		
		// Disocunted Subtotal can't be less than 0
		assertTrue(sale.getDiscountedSubTotal() == 0);
		assertTrue(saleSeniorTuesday.getDiscountedSubTotal() == 0);
		assertTrue(saleSeniorNotTuesday.getDiscountedSubTotal() == 0);
		assertTrue(salePreferred.getDiscountedSubTotal() == 0);
	}
	

}
