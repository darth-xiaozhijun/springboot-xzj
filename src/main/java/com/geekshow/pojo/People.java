package com.geekshow.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_people")
public class People {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//strategy=GenerationType.IDENTITY 自增长
	@Column(name="userid")
	private Integer peopleid;
	
	@Column(name="username")
	private String peoplename;
	
	@Column(name="userage")
	private Integer peopleage;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="roles_id")
	private Roles roles;

	public Integer getPeopleid() {
		return peopleid;
	}

	public void setPeopleid(Integer peopleid) {
		this.peopleid = peopleid;
	}

	public String getPeoplename() {
		return peoplename;
	}

	public void setPeoplename(String peoplename) {
		this.peoplename = peoplename;
	}

	public Integer getPeopleage() {
		return peopleage;
	}

	public void setPeopleage(Integer peopleage) {
		this.peopleage = peopleage;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "People [peopleid=" + peopleid + ", peoplename=" + peoplename + ", peopleage=" + peopleage + "]";
	}
	
}
