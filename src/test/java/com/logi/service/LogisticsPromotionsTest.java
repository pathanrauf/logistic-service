package com.logi.service;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.logi.dto.CartDetails;
import com.logi.dto.SKUDetails;

public class LogisticsPromotionsTest
{
	LogisticsPromotions logisticsPromotions = new LogisticsPromotions();

	@Before
	public void init() {
		logisticsPromotions.init();
	}

	@Test
	public void testGetPromotionalAmount_scenarioA() {
		Set<CartDetails> cartItems = new HashSet<CartDetails>();
		cartItems.add(new CartDetails(new SKUDetails('A', 50), 1));
		cartItems.add(new CartDetails(new SKUDetails('B', 30), 1));
		cartItems.add(new CartDetails(new SKUDetails('C', 20), 1));
		assertEquals(100, logisticsPromotions.getPromotionalAmount(cartItems));
	}

	@Test
	public void testGetPromotionalAmount_scenarioB() {
		Set<CartDetails> cartItems = new HashSet<CartDetails>();
		cartItems.add(new CartDetails(new SKUDetails('A', 50), 5));
		cartItems.add(new CartDetails(new SKUDetails('B', 30), 5));
		cartItems.add(new CartDetails(new SKUDetails('C', 20), 1));
		assertEquals(370, logisticsPromotions.getPromotionalAmount(cartItems));
	}

	@Test
	public void testGetPromotionalAmount_scenarioC() {
		Set<CartDetails> cartItems = new HashSet<CartDetails>();
		cartItems.add(new CartDetails(new SKUDetails('A', 50), 3));
		cartItems.add(new CartDetails(new SKUDetails('B', 30), 5));
		cartItems.add(new CartDetails(new SKUDetails('C', 20), 1));
		cartItems.add(new CartDetails(new SKUDetails('D', 15), 1));
		assertEquals(285, logisticsPromotions.getPromotionalAmount(cartItems));
	}
}
