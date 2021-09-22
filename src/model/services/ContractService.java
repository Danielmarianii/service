package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private PaymentService paymentService;

	public ContractService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		
	for (int i = 1; i <= months; i++) {
		Date date = addMonths(contract.getDate(), i);
		double updatedQuota = basicQuota +paymentService.monthlyFee(basicQuota, i);
		double fullQuota = updatedQuota +paymentService.paymentFee(updatedQuota);
		contract.addInstallment(new Installment(date, fullQuota));
	}
	}
	
	private Date addMonths(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}
}
