package com.awign.spring.files.csv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "mobile")
  private String mobile;

  @Column(name = "country")
  private String country;
  
  @Column(name = "mobileLength")
  private String mobileLength;


  public User() {

  }

  public User(long id, String name, String mobile, String country, String mobileLength) {
    this.id = id;
    this.name = name;
    this.mobile = mobile;
    this.country = country;
    this.mobileLength = mobileLength;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}



public String getMobileLength() {
	return mobileLength;
}

public void setMobileLength(String mobileLength) {
	this.mobileLength = mobileLength;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + ", mobileLength="
			+ mobileLength + "]";
}





}
