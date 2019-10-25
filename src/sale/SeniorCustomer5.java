package sale;

public class SeniorCustomer5 extends Sale5 {
	
	private static final double DISCOUNT_RATE = 0.05;
	private static final double DISCOUNT_RATE_SENIOR = 0.15;
	
	// Tuesday is the third day of the 7 day week (0-6 with Sunday starting at 0)
	private static final int TUESDAY = 2;
	
	private int day;
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public double getDiscountRate() {
		return day == TUESDAY ? DISCOUNT_RATE_SENIOR : DISCOUNT_RATE;
	}
}
