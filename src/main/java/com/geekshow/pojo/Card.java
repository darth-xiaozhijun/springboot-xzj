package com.geekshow.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_card")
public class Card implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cardid")
	private Integer cardid;
	
	@Column(name="cardno")
	private String cardno;
	
	@Column(name="cardaddr")
	private String cardaddr;
	
	@OneToOne(mappedBy="card")
	private Peoples peoples;

	public Integer getCardid() {
		return cardid;
	}

	public void setCardid(Integer cardid) {
		this.cardid = cardid;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardaddr() {
		return cardaddr;
	}

	public void setCardaddr(String cardaddr) {
		this.cardaddr = cardaddr;
	}

	public Peoples getPeoples() {
		return peoples;
	}

	public void setPeoples(Peoples peoples) {
		this.peoples = peoples;
	}

	@Override
	public String toString() {
		return "IdCard [cardid=" + cardid + ", cardno=" + cardno + ", cardaddr=" + cardaddr + "]";
	}
	
	
}
