package com.Shipping.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@Entity
@Table(name="company")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class SModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	
	//@NotBlank
	private String cmpname;
	
	//@NotBlank
	private String ownname;
	
	//@NotBlank
	private String email;
	
	//@NotBlank
	private String cnumber;
	
	//private String departingport_city;
	/*
	private String destinationport_city;
	
	private Date departDate;
	
	private Date DesDate;
	
	private double cost_p;
	
	private String goodcategory;
	
	private float tax;
	
	private String status;
	*/
	/*
	public String getDepartingport_city() {
		return departingport_city;
	}

	public void setDepartingport_city(String departingport_city) {
		this.departingport_city = departingport_city;
	}
	*/
/*
	public String getDestinationport_city() {
		return destinationport_city;
	}

	public void setDestinationport_city(String destinationport_city) {
		this.destinationport_city = destinationport_city;
	}

	public Date getDepartDate() {
		return departDate;
	}

	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}

	public Date getDesDate() {
		return DesDate;
	}

	public void setDesDate(Date desDate) {
		DesDate = desDate;
	}

	public double getCost_p() {
		return cost_p;
	}

	public void setCost_p(double cost_p) {
		this.cost_p = cost_p;
	}

	public String getGoodcategory() {
		return goodcategory;
	}

	public void setGoodcategory(String goodcategory) {
		this.goodcategory = goodcategory;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
*/
	
	
	//@NotBlank
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCmpname() {
		return cmpname;
	}

	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}

	public String getOwnname() {
		return ownname;
	}

	public void setOwnname(String ownname) {
		this.ownname = ownname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnumber() {
		return cnumber;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	
	
	
	
	
	
	
}
