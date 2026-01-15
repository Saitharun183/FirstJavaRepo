package com.st.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Garage_Sales")
public class GarageSale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer saleId;
	
	private String postalCode;

	private String name;
	
	private String street;
	
	private List<String> items;
}
