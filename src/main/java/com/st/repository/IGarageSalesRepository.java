package com.st.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.entity.GarageSale;

public interface IGarageSalesRepository extends JpaRepository<GarageSale, Integer> {

}
