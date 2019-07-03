package br.com.runner.storecorner.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.runner.storecorner.domain.enums.PaymentStatus;

@Entity
@JsonTypeName("paymentWithCard")
public class PaymentWithCard extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer paymentInstallments;
	
	public PaymentWithCard() {
	}

	public PaymentWithCard(Integer id, PaymentStatus paymentStatus, Order order, Integer paymentInstallments) {
		super(id, paymentStatus, order);
		this.paymentInstallments = paymentInstallments;
	}

	public Integer getPaymentInstallments() {
		return paymentInstallments;
	}

	public void setPaymentInstallments(Integer paymentInstallments) {
		this.paymentInstallments = paymentInstallments;
	}
}
