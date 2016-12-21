package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.validation.EmptyOrSize;

@Entity
public class Item implements Serializable {
	private static final long serialVersionUID = 5784L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	@NotEmpty
	private String name;
    public Item() {
		super();
	}
	public Item(String name, String description, float price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	private String description;
	
//    @EmptyOrSize(min = 2, max = 10, message = "{EmptyOrSize}")
	private String itemId;
//    @Min(value=5)
	private float price;
    @Transient
    private MultipartFile itemImage;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "category_ID")
    private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

    public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public MultipartFile getItemImage() {
		return itemImage;
	}
	public void setItemImage(MultipartFile itemImage) {
		this.itemImage = itemImage;
	}
}