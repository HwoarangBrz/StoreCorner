package br.com.runner.storecorner.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.runner.storecorner.domain.PaymentWithBankSlip;

@Service
public class TicketService {

	public void fillPaymentWithBankSlip(PaymentWithBankSlip pagto, Date orderInstant) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(orderInstant);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setExpireDate(cal.getTime());
	}
}
