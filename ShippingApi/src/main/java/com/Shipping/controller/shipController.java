package com.Shipping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import javax.validation.Valid;

import com.Shipping.model.SModel;
import com.Shipping.model.shipModel;

import com.Shipping.repository.shipRepository;

@RestController
@RequestMapping("/IT")
public class shipController {
	
	@Autowired
	shipRepository shipRepo;
	
	//Get All
		@GetMapping("/ship")
		public List<shipModel> getAllships(){
			return shipRepo.findAll();
		}
	
	//insert ship
	@PostMapping("/ship")
	public shipModel createsship(@Valid @RequestBody shipModel shmodel) {
        return shipRepo.save(shmodel);
    }
	

}
