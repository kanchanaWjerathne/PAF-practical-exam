package com.Shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.validation.Valid;

import com.Shipping.repository.ShippingRepository;
import com.Shipping.exception.ResourceNotFoundException;
import com.Shipping.model.SModel;

@RestController
@RequestMapping("/IT")
public class ShippingController {
	@Autowired
	ShippingRepository shippingRepository;
	
	
	//Get All
	@GetMapping("/shipping")
	public List<SModel> getAllscompany(){
		return shippingRepository.findAll();
	}
	 // Create a new
	@PostMapping("/shipping")
	public SModel createscompany(@Valid @RequestBody SModel smodel) {
        return shippingRepository.save(smodel);
    }
	
	// Get a Single company
	@GetMapping("/shipping/{id}")
	 public SModel getscompanyById(@PathVariable(value = "id") Integer shipid) {
	       return shippingRepository.findById(shipid)
	               .orElseThrow(() -> new ResourceNotFoundException("SModel", "cid", shipid));
	  }
	 // Update a company
	 @PutMapping("/shipping/{id}")

	public SModel updatescompany(@PathVariable(value = "id") Integer shipid,
							@Valid @RequestBody SModel scompanyDetails)
	{

		SModel smodle = shippingRepository.findById(shipid)
					.orElseThrow(() -> new ResourceNotFoundException("SModel", "cid", shipid));

		smodle.setCmpname(scompanyDetails.getCmpname());


		SModel updatescompany = shippingRepository.save(smodle);
			return updatescompany;
		}
	 
	// Delete a Note
	
	 @DeleteMapping("/shipping/{id}")
	 public ResponseEntity<?> deletecompany(@PathVariable(value = "id") Integer shipid) {
		 SModel smodle = shippingRepository.findById(shipid)
	                .orElseThrow(() -> new ResourceNotFoundException("SModel", "cid", shipid));

		 shippingRepository.delete(smodle);

	        return ResponseEntity.ok().build();
	    }
	 
}
