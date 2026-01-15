package com.st.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.st.entity.GarageSale;
import com.st.exception.SaleNotFoundException;
import com.st.repository.IGarageSalesRepository;

@Service
public class GarageSaleServiceImpl implements IGarageSalesService{
	
	private IGarageSalesRepository repo;
	
	public GarageSaleServiceImpl(IGarageSalesRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public GarageSale addSale(GarageSale sale) {
		return repo.save(sale);
	}
	
	@Override
	public List<GarageSale> getAllSales() {
		List<GarageSale> sales = repo.findAll();
		return sales;
	}
	
	@Override
	public GarageSale getSale(int saleId) {
		return repo.findById(saleId)
							 .orElseThrow(() -> new SaleNotFoundException("Garage Sale not found with id "+saleId));
	}
	
	@Override
	public GarageSale updateSale(int saleId, GarageSale updatedSale) {
		GarageSale existingSale = repo.findById(saleId)
																.orElseThrow(() -> new SaleNotFoundException("Garage Sale not found with id "+saleId));
		
		existingSale.setPostalCode(updatedSale.getPostalCode());
		existingSale.setName(updatedSale.getName());
		existingSale.setStreet(updatedSale.getStreet());
		existingSale.setItems(updatedSale.getItems());
		
		return repo.save(existingSale);
		
	}

	
	@Override
	public String deleteSale(int saleId) {
		if(!repo.existsById(saleId)) {
			throw new SaleNotFoundException("Garage Sale Not Found with id "+saleId);
		}
		repo.deleteById(saleId);
		return "Successfully deleted the sale with id "+saleId;
	}
	
}
