package problem1;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class Sale1Tests {

	@Test
	void getDiscountSuccess() {
		Sale1 sale = new Sale1();
		Item1 item = new Item1();
		// if there are no items, the discount is 0
		assertTrue(sale.getDiscount() == 0);
		
		item.setTitle("Test Item");
		item.setItemTotal(1.00);
		item.setQuantity(1);
		sale.addItem(item);
		
		assertTrue(sale.getDiscount() == 0.05);
		
		item.setTitle("Test Item 2");
		item.setItemTotal(1.50);
		item.setQuantity(1);
		sale.addItem(item);
		
		// if the subtotal increases the discount should also increase
		assertTrue(sale.getDiscount() > 0.05);
	}
	
	@Test
	void getDiscountNegative() {
		Sale1 sale = new Sale1();
		Item1 item = new Item1();
		item.setTitle("Bad Test Item");
		item.setItemTotal(-1.00);
		item.setQuantity(1);
		sale.addItem(item);
		
		// Discount can't be less than 0
		assertTrue(sale.getDiscount() == 0);
	}
	
	@Test
	void getSubTotalSuccess() {
		Sale1 sale = new Sale1();
		Item1 item = new Item1();
		// if there are no items, the subtotal is 0
		assertTrue(sale.getSubTotal() == 0);
		
		item.setTitle("Test Item");
		item.setItemTotal(1.00);
		item.setQuantity(1);
		sale.addItem(item);
		
		assertTrue(sale.getSubTotal() == 1);
		
		item.setTitle("Test Item 2");
		item.setItemTotal(1.50);
		item.setQuantity(1);
		sale.addItem(item);
		
		// if the subtotal increases the subtotal should also increase
		assertTrue(sale.getSubTotal() > 1);
	}
	
	@Test
	void getSubTotalNegative() {
		Sale1 sale = new Sale1();
		Item1 item = new Item1();
		item.setTitle("Bad Test Item");
		item.setItemTotal(-1.00);
		item.setQuantity(1);
		sale.addItem(item);
		
		// Subtotal can't be less than 0
		assertTrue(sale.getDiscount() == 0);
	}
	
	@Test
	void getDiscountedSubTotalSuccess() {
		Sale1 sale = new Sale1();
		Item1 item = new Item1();
		// if there are no items, the DiscountedSubtotal is 0
		assertTrue(sale.getDiscountedSubTotal() == 0);
		
		item.setTitle("Test Item");
		item.setItemTotal(1.00);
		item.setQuantity(1);
		sale.addItem(item);
		
		assertTrue(sale.getDiscountedSubTotal() == 0.95);
		
		item.setTitle("Test Item 2");
		item.setItemTotal(1.50);
		item.setQuantity(1);
		sale.addItem(item);
		
		// if the subtotal increases the discounted subtotal should also increase
		assertTrue(sale.getDiscountedSubTotal() > 0.95);
	}
	
	@Test
	void getDiscountedSubTotalNegative() {
		Sale1 sale = new Sale1();
		Item1 item = new Item1();
		item.setTitle("Bad Test Item");
		item.setItemTotal(-1.00);
		item.setQuantity(1);
		sale.addItem(item);
		
		// Disocunted Subtotal can't be less than 0
		assertTrue(sale.getDiscountedSubTotal() == 0);
	}
	

}
