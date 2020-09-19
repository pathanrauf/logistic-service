package com.logi.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.logi.dto.CartDetails;
import com.logi.dto.CombineItemsPromo;
import com.logi.dto.NItemsPromo;
import com.logi.dto.SKUDetails;

public class LogisticsPromotions
{
	/*
	 * Below static code should be part of database
	 */
	private static Set<NItemsPromo> activeNItemsPromos = new HashSet<NItemsPromo>();
	private static Set<CombineItemsPromo> activeCombineItemsPromos = new HashSet<CombineItemsPromo>();

	static Set<SKUDetails> skuDetailsItems;

	private static int numberOfPromo = 3;

	public void init() {
		activeNItemsPromos.add(new NItemsPromo(new SKUDetails('A', 50), 3, 130));
		activeNItemsPromos.add(new NItemsPromo(new SKUDetails('B', 30), 2, 45));

		activeCombineItemsPromos.add(new CombineItemsPromo(new HashSet<SKUDetails>(Arrays.asList(new SKUDetails('C', 20), new SKUDetails('D', 15))), 30));

		skuDetailsItems = new HashSet<SKUDetails>();
		skuDetailsItems.add(new SKUDetails('A', 50));
		skuDetailsItems.add(new SKUDetails('B', 30));
		skuDetailsItems.add(new SKUDetails('C', 20));
		skuDetailsItems.add(new SKUDetails('D', 15));
	}

	public int getPromotionalAmount(Set<CartDetails> cartItems) {

		Map<Character, List<CartDetails>> cartMap = cartItems.stream().collect(Collectors.groupingBy(e -> e.getSKUDetails().getSkuName(), Collectors.toList()));

		Map<Character, List<NItemsPromo>> activeNItemsPromosMap = activeNItemsPromos.stream()
				.collect(Collectors.groupingBy(e -> e.getSkuDetails().getSkuName(), Collectors.toList()));

		int totalAmount = 0;
		int index = 0;
		for (Map.Entry<Character, List<CartDetails>> skuNameEntry : cartMap.entrySet()) {
			CartDetails cartDetails = skuNameEntry.getValue().get(0);

			if (numberOfPromo > index && activeNItemsPromosMap.containsKey(skuNameEntry.getKey())
					&& cartDetails.getItemCount() >= activeNItemsPromosMap.get(skuNameEntry.getKey()).get(0).getCount()) {
				NItemsPromo nItemsPromo = activeNItemsPromosMap.get(skuNameEntry.getKey()).get(0);
				int multiple = Math.toIntExact(cartDetails.getItemCount() / nItemsPromo.getCount());
				int remainder = Math.toIntExact(cartDetails.getItemCount() % nItemsPromo.getCount());

				totalAmount += multiple * nItemsPromo.getTotal() + remainder * cartDetails.getSKUDetails().getPrice();
				++index;
			} else {
				totalAmount += cartDetails.getSKUDetails().getPrice() * cartDetails.getItemCount();
			}
		}
		return totalAmount;
	}

}
