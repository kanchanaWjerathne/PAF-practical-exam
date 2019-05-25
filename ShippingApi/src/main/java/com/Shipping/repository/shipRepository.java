package com.Shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shipping.model.shipModel;

public interface shipRepository extends JpaRepository<shipModel, Integer> {

}
