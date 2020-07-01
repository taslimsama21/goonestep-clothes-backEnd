package com.sama.manage.employee.models;

import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employee", uniqueConstraints = { @UniqueConstraint(columnNames = "empId") })
public class Employee {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "empId")
	private Long empId;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "address")
	private String address;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "city")
	private String city;

	@Column(name = "dateofBirth")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateofBirth;

	public Employee() {
	}

	public Employee(Long empId, String firstname, String lastname, String address, String mobile, String city,
			Date dateofBirth) {
		this.empId = empId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.mobile = mobile;
		this.city = city;
		this.dateofBirth = dateofBirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
}
