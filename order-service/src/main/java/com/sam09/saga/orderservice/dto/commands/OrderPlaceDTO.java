/**
 * 
 */
package com.sam09.saga.orderservice.dto.commands;

import java.math.BigDecimal;

/**
 * @author soumya
 *
 */
public class OrderPlaceDTO {

	private String item;
	private BigDecimal price;
	private String currency;
	
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrenct(String currency) {
		this.currency = currency;
	}
}
