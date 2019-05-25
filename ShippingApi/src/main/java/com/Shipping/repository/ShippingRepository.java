package com.Shipping.repository;

import com.Shipping.model.SModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<SModel, Integer> {
	
}
