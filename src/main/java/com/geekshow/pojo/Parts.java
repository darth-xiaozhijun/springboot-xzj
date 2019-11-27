package com.geekshow.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_parts")
public class Parts {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="partid")
	private Integer partid;
	
	@Column(name="partname")
	private String partname;
	
	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	//@JoinTable:配置中间表信息
	//joinColumns:建立当前表在中间表中的外键字段
	@JoinTable(name="t_parts_menus",joinColumns=@JoinColumn(name="part_id"),inverseJoinColumns=@JoinColumn(name="menu_id"))
	private Set<Menus> menus = new HashSet<>();

	public Integer getPartid() {
		return partid;
	}

	public void setPartid(Integer partid) {
		this.partid = partid;
	}

	public String getPartname() {
		return partname;
	}

	public void setPartname(String partname) {
		this.partname = partname;
	}

	public Set<Menus> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menus> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "Parts [partid=" + partid + ", partname=" + partname + "]";
	}
	
}
