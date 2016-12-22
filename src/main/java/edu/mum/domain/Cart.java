package edu.mum.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.Valid;

@Entity
public class Cart {
	@Id
	@Column(nullable = false, unique = true)
	private String cartname;
	
	@Version
	@Column(name = "version")
	private int version = 0;

	@OneToOne(mappedBy = "cart", cascade = CascadeType.PERSIST)
	private User user;
	
	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CartItem> cartItemList = new HashSet<CartItem>();

	public Cart() {
		
	}
	
	public String getCartName() {
		return cartname;
	}

	public void setCartName(String cartname) {
		this.cartname = cartname;
	}
	
	public Set<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(Set<CartItem> cartItems) {
		this.cartItemList = cartItems;
	}
}
