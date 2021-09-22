package model.services;

public interface PaymentService {

	double paymentFee(double amount);
	double monthlyFee(double amount, int months);
}
