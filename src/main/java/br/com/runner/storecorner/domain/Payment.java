package br.com.runner.storecorner.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.com.runner.storecorner.domain.enums.PaymentStatus;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer situation;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name="oder_id")
	@MapsId
	private Order order;
	
	public Payment() {
	}

	public Payment(Integer id, PaymentStatus situation, Order order) {
		super();
		this.id = id;
		this.situation = (situation==null) ? null : situation.getCod();
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentStatus getSituation() {
		return PaymentStatus.toEnum(situation);
	}

	public void setSituation(PaymentStatus situation) {
		this.situation = situation.getCod();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
