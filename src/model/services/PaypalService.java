package model.services;

public class PaypalService implements PaymentService{

	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_FEE = 0.01;
	
	@Override
	public double paymentFee(double amount) {
		return amount * FEE_PERCENTAGE;
	}

	@Override
	public double monthlyFee(double amount, int months) {
		return amount * MONTHLY_FEE * months;
	}
}
