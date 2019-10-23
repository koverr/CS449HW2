package tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import item.Item;
import sale.Sale;

class ItemTests {

	
	
	@Test
	void getDiscountSuccess() {
		Sale sale = new Sale();
		Item item = new Item();
		// if there are no items, the discount is 0
		assertTrue(sale.getDiscount() == 0);
		
		item.setTitle("Test Item");
		item.setItemTotal(1.00);
		item.setQuantity(1);
		sale.addItem(item);
		
		assertTrue(sale.getDiscount() == 0.05);
	}
	
	@Test
	void getDiscountFailure() {
		Sale sale = new Sale();
		Item item = new Item();
		item.setTitle("Bad Test Item");
		item.setItemTotal(-1.00);
		item.setQuantity(1);
		sale.addItem(item);
		
		// Discount can't be less than 0
		assertTrue(sale.getDiscount() == 0);
	}
	
	
	

}
