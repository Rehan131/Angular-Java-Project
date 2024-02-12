package com.example.ProjectPracticeAngular.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mobile {

	@Id
	private Integer mobileid;
	private String mobileName;
	private Integer price;
	private Integer speed;
	private String photo;
	
	
	public Mobile() {
		
	}

	public Mobile(int mobileid, int price, int speed, String mobileName,String photo) {
		super();
		this.mobileid = mobileid;
		this.price = price;
		this.speed = speed;
		this.mobileName = mobileName;
		this.photo=photo;
	}

	public Integer getMobileid() {
		return mobileid;
	}

	public void setMobileid(Integer mobileid) {
		this.mobileid = mobileid;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Mobile [mobileid=" + mobileid + ", mobileName=" + mobileName + ", price=" + price + ", speed=" + speed
				+ ", photo=" + photo + "]";
	}

	
}
