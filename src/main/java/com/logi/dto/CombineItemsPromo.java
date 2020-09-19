package com.logi.dto;

import java.util.Set;
import java.util.TreeSet;

public class CombineItemsPromo
{
	private Set<SKUDetails> skuDetailsSet;
	private int total;

	public CombineItemsPromo(Set<SKUDetails> skuDetailsSet, int total) {
		this.skuDetailsSet = skuDetailsSet;
		this.total = total;
	}

	public Set<SKUDetails> getSkuDetailsSet() {
		if (null == skuDetailsSet) {
			skuDetailsSet = new TreeSet<SKUDetails>();
		}
		return skuDetailsSet;
	}

	public void setSkuDetailsSet(Set<SKUDetails> skuNameSet) {
		this.skuDetailsSet = skuNameSet;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "CombineItemsPromo [skuDetailsSet=" + skuDetailsSet + ", total=" + total + "]";
	}

}