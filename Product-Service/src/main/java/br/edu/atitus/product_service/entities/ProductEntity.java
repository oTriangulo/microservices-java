package br.edu.atitus.product_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_product")

public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description_product", nullable = false, length = 3)
	private String description;
	
	@Column(name = "brand_product", nullable = false, length = 3)
	private String brand;
	
	@Column(name = "model_product", nullable = false, length = 3)
	private String model;

	@Column(name = "price_product", nullable = false, length = 3)
	private double price;
	
	@Column(name = "currency_product", nullable = false, length = 3)
	private String currency;
	
	@Column(name = "stock_product", nullable = false, length = 3)
	private Integer stock;
	
	@Transient
	private double convertedPrice;
	
	@Transient
	private String environment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public double getConvertedPrice() {
		return convertedPrice;
	}

	public void setConvertedPrice(double convertedPrice) {
		this.convertedPrice = convertedPrice;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	
}
