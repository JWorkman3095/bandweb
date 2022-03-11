package com.maxtrain.bootcamp.band;

import javax.persistence.*;

@Entity
//unique
@Table(uniqueConstraints=@UniqueConstraint(name="UIDX_code", columnNames={"code"}))
public class Band {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int")
	private int Id;
	@Column(length=30, nullable=false)
	private String BandName;
	@Column(length=30, nullable=false)
	private String Code;
	@Column(length=30, nullable=false)
	private String City;
	@Column(length=2, nullable=false)
	private String StateCode;
	@Column(length=30, nullable=false)
	private String ContactName;
	@Column(length=12, nullable=false)
	private String Phone;
	
	public Band () {}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getBandName() {
		return BandName;
	}

	public void setBandName(String bandName) {
		BandName = bandName;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getStateCode() {
		return StateCode;
	}

	public void setStateCode(String stateCode) {
		StateCode = stateCode;
	}

	public String getContactName() {
		return ContactName;
	}

	public void setContactName(String contactName) {
		ContactName = contactName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	
	
	

}
