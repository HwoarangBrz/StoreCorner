package br.com.runner.storecorner.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.runner.storecorner.domain.enums.PaymentStatus;

@Entity
@JsonTypeName("paymentWithBankSlip")
public class PaymentWithBankSlip extends Payment {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date expireDate;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date paymentDate;

	public PaymentWithBankSlip() {
	}

	public PaymentWithBankSlip(Integer id, PaymentStatus paymentStatus, Order order, Date expireDate, Date paymentDate) {
		super(id, paymentStatus, order);
		this.paymentDate = paymentDate;
		this.expireDate = expireDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}	
	
}
