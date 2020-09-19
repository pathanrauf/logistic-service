package com.logi.dto;

public class SKUDetails
{
	private Character skuName;
	private int price;

	public SKUDetails(Character skuName, int price) {
		super();
		this.skuName = skuName;
		this.price = price;
	}

	public SKUDetails(Character skuName) {
		super();
		this.skuName = skuName;
	}

	public Character getSkuName() {
		return skuName;
	}

	public void setSkuName(Character skuName) {
		this.skuName = skuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + skuName;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SKUDetails other = (SKUDetails) obj;
		if (skuName != other.skuName)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SKUDetails [skuDetails=" + skuName + ", price=" + price + "]";
	}

}
