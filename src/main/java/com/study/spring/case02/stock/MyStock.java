package com.study.spring.case02.stock;

public class MyStock {
	private String symbol;
	@Override
	public String toString() {
		return "MyStock [symbol=" + symbol + ", price=" + price + "]";
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	private Double price;
}
