package com.logi.dto;

public class NItemsPromo 
{
	private SKUDetails skuDetails;
	private int count;
	private int total;

	public NItemsPromo(SKUDetails skuDetails, int count, int total) {
		this.skuDetails = skuDetails;
		this.count = count;
		this.total = total;
	}

	public SKUDetails getSkuDetails() {
		return skuDetails;
	}

	public void setSkuDetails(SKUDetails skuDetails) {
		this.skuDetails = skuDetails;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((skuDetails == null) ? 0 : skuDetails.hashCode());
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
		NItemsPromo other = (NItemsPromo) obj;
		if (count != other.count)
			return false;
		if (skuDetails == null) {
			if (other.skuDetails != null)
				return false;
		} else if (!skuDetails.equals(other.skuDetails))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NItemsPromo [skuDetails=" + skuDetails + ", count=" + count + ", total=" + total + "]";
	}

}
