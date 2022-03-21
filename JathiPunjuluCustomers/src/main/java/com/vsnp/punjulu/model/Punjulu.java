package com.vsnp.punjulu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

import com.vsnp.punjulu.util.PunjuStatus;

@Entity
@Table(name = "punjulu")
public class Punjulu {

	@Id
	@GeneratedValue
	private Integer id;

	private String type;

	private Double price;

	// comma separated images
	private String images;

	private PunjuStatus status;

	public PunjuStatus getStatus() {
		return status;
	}

	public Punjulu() {
		// TODO Auto-generated constructor stub
	}
	
	public void setStatus(PunjuStatus status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

}
