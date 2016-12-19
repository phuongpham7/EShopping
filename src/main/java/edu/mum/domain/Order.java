package edu.mum.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "purchaseOrder")

public class Order {
	  @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(name = "id", updatable = false, nullable = false)
	   private Long id = null;
	   @Version
	   @Column(name = "version")
	   private int version = 0;

	   @Column
	   private String orderNumber;

	   public Order(String orderNumber, Set<OrderItem> items, OrderPayment payments) {

		this.orderNumber = orderNumber;
		this.items = items;
		this.payments = payments;
	}

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	   private Set<OrderItem> items = new HashSet<OrderItem>();

	   @OneToOne
	   private OrderPayment payments;
	   
	public void setPayments(OrderPayment payments) {
		this.payments = payments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
	
	
	public void addOrderItem(OrderItem orderItem) {
		this.items.add(orderItem);
		orderItem.setOrder(this);
	}

	
}
