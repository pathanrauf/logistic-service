package com.logi.dto;

public class CartDetails
{
	private SKUDetails skuDetails;
	private int itemCount;

	public CartDetails(SKUDetails skuDetails, int itemCount) {
		super();
		this.skuDetails = skuDetails;
		this.itemCount = itemCount;
	}

	public SKUDetails getSKUDetails() {
		return skuDetails;
	}

	public void setSKUDetails(SKUDetails details) {
		this.skuDetails = details;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	@Override
	public String toString() {
		return "CartDetails [skuDetails=" + skuDetails + ", itemCount=" + itemCount + "]";
	}

}