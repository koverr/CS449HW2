package problem2;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import problem1.Item1;

class Sale2Tests {

	@Test
	void getDiscountSuccess() {		
		Sale2 sale = new Sale2();
		Sale2 saleSenior = new Sale2();
		saleSenior.setCustomerType("Senior");
		Sale2 salePreferred = new Sale2();
		salePreferred.setCustomerType("Preferred");
		
		Item1 item = new Item1();
		
		// if there are no items, the discount is 0
		assertTrue(sale.getDiscount() == 0);
		assertTrue(saleSenior.getDiscount() == 0);
		assertTrue(salePreferred.getDiscount() == 0);
		
		item.setTitle("Test Item");
		item.setItemTotal(1.00);
		item.setQuantity(1);
		sale.addItem(item);
		saleSenior.addItem(item);
		salePreferred.addItem(item);
		
		// Check that the different customers have different discounts
		assertTrue(sale.getDiscount() == 0.05);
		// Bogus Double memory handling shenanigans
		assertTrue(saleSenior.getDiscount() == 0.15000000000000002);
		assertTrue(salePreferred.getDiscount() == 0.2);
		
		item.setTitle("Test Item 2");
		item.setItemTotal(1.50);
		item.setQuantity(1);
		sale.addItem(item);
		saleSenior.addItem(item);
		salePreferred.addItem(item);
		
		// if the subtotal increases the discount should also increase
		assertTrue(sale.getDiscount() > 0.05);
		assertTrue(saleSenior.getDiscount() > 0.15);
		assertTrue(salePreferred.getDiscount() > 0.2);
	}
	
	@Test
	void getDiscountNegative() {
		Sale2 sale = new Sale2();
		Sale2 saleSenior = new Sale2();
		saleSenior.setCustomerType("Senior");
		Sale2 salePreferred = new Sale2();
		salePreferred.setCustomerType("Preferred");
		
		Item1 item = new Item1();
		
		item.setTitle("Bad Test Item");
		item.setItemTotal(-1.00);
		item.setQuantity(1);
		sale.addItem(item);
		saleSenior.addItem(item);
		salePreferred.addItem(item);
		
		// Discount can't be less than 0
		assertTrue(sale.getDiscount() == 0);
		assertTrue(saleSenior.getDiscount() == 0);
		assertTrue(salePreferred.getDiscount() == 0);
	}
	
	@Test
	void getSubTotalSuccess() {
		Sale2 sale = new Sale2();
		Sale2 saleSenior = new Sale2();
		saleSenior.setCustomerType("Senior");
		Sale2 salePreferred = new Sale2();
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
		Sale2 sale = new Sale2();
		Sale2 saleSenior = new Sale2();
		saleSenior.setCustomerType("Senior");
		Sale2 salePreferred = new Sale2();
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
		Sale2 sale = new Sale2();
		Sale2 saleSenior = new Sale2();
		saleSenior.setCustomerType("Senior");
		Sale2 salePreferred = new Sale2();
		salePreferred.setCustomerType("Preferred");
		
		Item1 item = new Item1();
		
		// if there are no items, the DiscountedSubtotal is 0
		assertTrue(sale.getDiscountedSubTotal() == 0);
		assertTrue(saleSenior.getDiscountedSubTotal() == 0);
		assertTrue(salePreferred.getDiscountedSubTotal() == 0);
		
		item.setTitle("Test Item");
		item.setItemTotal(1.00);
		item.setQuantity(1);
		sale.addItem(item);
		saleSenior.addItem(item);
		salePreferred.addItem(item);
		
		assertTrue(sale.getDiscountedSubTotal() == 0.95);
		assertTrue(saleSenior.getDiscountedSubTotal() == 0.85);
		assertTrue(salePreferred.getDiscountedSubTotal() == 0.8);
		
		item.setTitle("Test Item 2");
		item.setItemTotal(1.50);
		item.setQuantity(1);
		sale.addItem(item);
		saleSenior.addItem(item);
		salePreferred.addItem(item);
		
		// if the subtotal increases the discounted subtotal should also increase
		assertTrue(sale.getDiscountedSubTotal() > 0.95);
		assertTrue(saleSenior.getDiscountedSubTotal() > 0.85);
		assertTrue(salePreferred.getDiscountedSubTotal() > 0.8);
	}
	
	@Test
	void getDiscountedSubTotalNegative() {
		Sale2 sale = new Sale2();
		Sale2 saleSenior = new Sale2();
		saleSenior.setCustomerType("Senior");
		Sale2 salePreferred = new Sale2();
		salePreferred.setCustomerType("Preferred");
		
		Item1 item = new Item1();
		
		item.setTitle("Bad Test Item");
		item.setItemTotal(-1.00);
		item.setQuantity(1);
		sale.addItem(item);
		saleSenior.addItem(item);
		salePreferred.addItem(item);
		
		// Disocunted Subtotal can't be less than 0
		assertTrue(sale.getDiscountedSubTotal() == 0);
		assertTrue(saleSenior.getDiscountedSubTotal() == 0);
		assertTrue(salePreferred.getDiscountedSubTotal() == 0);
	}
	

}
