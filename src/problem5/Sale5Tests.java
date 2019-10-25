package problem5;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class Sale5Tests {

	@Test
	void getDiscountSuccess() {		
		NormalCustomer5 sale = new NormalCustomer5();
		SeniorCustomer5 saleSeniorTuesday = new SeniorCustomer5();
		saleSeniorTuesday.setDay(2);
		SeniorCustomer5 saleSeniorNotTuesday = new SeniorCustomer5();
		saleSeniorNotTuesday.setDay(5);
		PreferredCustomer5 salePreferred = new PreferredCustomer5();
		
		Item5 item = new Item5();
		Item5 item2 = new Item5();
		
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
		assertTrue(saleSeniorTuesday.getDiscount() == 0.15);
		assertTrue(saleSeniorNotTuesday.getDiscount() == 0.05);
		assertTrue(salePreferred.getDiscount() == 0.2);
		
		item2.setTitle("Test Item 2");
		item2.setItemTotal(2.00);
		item2.setQuantity(2);
		item2.setSpecialItemCode(1);
		sale.addItem(item2);
		saleSeniorTuesday.addItem(item2);
		saleSeniorNotTuesday.addItem(item2);
		salePreferred.addItem(item2);
		
		// if the subtotal increases the discount should also increase
		// Also asserts that the multiple special item discount works
		assertTrue(sale.getDiscount() == 0.2);
		assertTrue(saleSeniorTuesday.getDiscount() == 0.6);
		assertTrue(saleSeniorNotTuesday.getDiscount() == 0.2);
		assertTrue(salePreferred.getDiscount() == 0.8);
	}
	
	@Test
	void getDiscountNegative() {
		NormalCustomer5 sale = new NormalCustomer5();
		SeniorCustomer5 saleSeniorTuesday = new SeniorCustomer5();
		saleSeniorTuesday.setDay(2);
		SeniorCustomer5 saleSeniorNotTuesday = new SeniorCustomer5();
		saleSeniorNotTuesday.setDay(5);
		PreferredCustomer5 salePreferred = new PreferredCustomer5();
		
		Item5 item = new Item5();
		
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
		NormalCustomer5 sale = new NormalCustomer5();
		SeniorCustomer5 saleSenior = new SeniorCustomer5();
		PreferredCustomer5 salePreferred = new PreferredCustomer5();
		
		Item5 item = new Item5();
		Item5 item2 = new Item5();
		
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
		
		item2.setTitle("Test Item 2");
		item2.setItemTotal(2.00);
		item2.setQuantity(2);
		item2.setSpecialItemCode(1);
		sale.addItem(item2);
		saleSenior.addItem(item2);
		salePreferred.addItem(item2);
		
		// if the subtotal increases the subtotal should also increase
		// also asserts that the special item discount works
		assertTrue(sale.getSubTotal() == 4);
		assertTrue(saleSenior.getSubTotal() == 4);
		assertTrue(salePreferred.getSubTotal() == 4);
	}
	
	@Test
	void getSubTotalNegative() {
		NormalCustomer5 sale = new NormalCustomer5();
		SeniorCustomer5 saleSenior = new SeniorCustomer5();
		PreferredCustomer5 salePreferred = new PreferredCustomer5();
		
		Item5 item = new Item5();
		
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
		NormalCustomer5 sale = new NormalCustomer5();
		SeniorCustomer5 saleSeniorTuesday = new SeniorCustomer5();
		saleSeniorTuesday.setDay(2);
		SeniorCustomer5 saleSeniorNotTuesday = new SeniorCustomer5();
		saleSeniorNotTuesday.setDay(5);
		PreferredCustomer5 salePreferred = new PreferredCustomer5();
		
		Item5 item = new Item5();
		Item5 item2 = new Item5();
		
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
		
		item2.setTitle("Test Item 2");
		item2.setItemTotal(2.00);
		item2.setQuantity(2);
		item2.setSpecialItemCode(1);
		sale.addItem(item2);
		saleSeniorTuesday.addItem(item2);
		saleSeniorNotTuesday.addItem(item2);
		salePreferred.addItem(item2);
		
		// if the subtotal increases the discounted subtotal should also increase
		assertTrue(sale.getDiscountedSubTotal() == 3.80);
		assertTrue(saleSeniorTuesday.getDiscountedSubTotal() == 3.40);
		assertTrue(saleSeniorNotTuesday.getDiscountedSubTotal() == 3.80);
		assertTrue(salePreferred.getDiscountedSubTotal() == 3.20);
	}
	
	@Test
	void getDiscountedSubTotalNegative() {
		NormalCustomer5 sale = new NormalCustomer5();
		SeniorCustomer5 saleSeniorTuesday = new SeniorCustomer5();
		saleSeniorTuesday.setDay(2);
		SeniorCustomer5 saleSeniorNotTuesday = new SeniorCustomer5();
		saleSeniorNotTuesday.setDay(5);
		PreferredCustomer5 salePreferred = new PreferredCustomer5();
		
		Item5 item = new Item5();
		
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
