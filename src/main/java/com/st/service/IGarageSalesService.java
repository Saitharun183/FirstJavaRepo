package com.st.service;

import java.util.List;

import com.st.entity.GarageSale;

public interface IGarageSalesService {
	
	public GarageSale addSale(GarageSale sale);
	
	public List<GarageSale> getAllSales();
	
	public GarageSale getSale(int saleId);
	
	public GarageSale updateSale(int saleId, GarageSale updatedSale);
	
	public String deleteSale(int saleId);
	
}
