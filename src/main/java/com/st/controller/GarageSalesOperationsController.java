package com.st.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.st.entity.GarageSale;
import com.st.response.ApiResponse;
import com.st.service.IGarageSalesService;

@RestController
public class GarageSalesOperationsController {
	
	private IGarageSalesService service;
	
	public GarageSalesOperationsController(IGarageSalesService service) {
		this.service = service;
	}
	
	@PostMapping("/add-sale/")
	public ResponseEntity<ApiResponse<GarageSale>> addSale(@RequestBody GarageSale sale){
		GarageSale newSale = service.addSale(sale);
		return ResponseEntity.ok(ApiResponse.success(newSale, "Created Sale Successfully"));
	}
	
	@GetMapping("/")
	public ResponseEntity<ApiResponse<List<GarageSale>>> fetchAllSales(){
		List<GarageSale> allSales = service.getAllSales();
		return ResponseEntity.ok(ApiResponse.success(allSales, "Fetched all sales successfully"));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<GarageSale>> fetchSale(@PathVariable int id){
		GarageSale fetchedSale = service.getSale(id);
		return ResponseEntity.ok(ApiResponse.success(fetchedSale, "Successfully fetched sale"));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse<GarageSale>> updateSale(@PathVariable int id, @RequestBody GarageSale sale){
		GarageSale updatedSale = service.updateSale(id, sale);
		return ResponseEntity.ok(ApiResponse.success(updatedSale, "Sale updated"));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse<String>> deleteSale(@PathVariable int id){
		String msg = service.deleteSale(id);
		return ResponseEntity.ok(ApiResponse.success(msg, msg));
	}
	
}
