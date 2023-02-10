package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 幣別
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name="currency")
public class Currency {
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id; // 序號
	@JsonProperty("code")
	@Column(name="code")
	private String code; // 幣別代碼
	@JsonProperty("name")
	@Column(name="name")
	private String name; // 貨幣名稱
	@JsonProperty("symbol")
	@Column(name="symbol")
	private String symbol; // 貨幣符號
	@JsonProperty("rate")
	private Double rate; // 匯率

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

}
