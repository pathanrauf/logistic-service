package com.logi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.logi.orderevents.ActivateMembershipEvent;
import com.logi.orderevents.AgentCommissionEvent;
import com.logi.orderevents.BookOrderEvent;
import com.logi.orderevents.PhysicalProductOrderEvent;
import com.logi.orderevents.SendEmailEvent;
import com.logi.orderevents.UpgradeMembershipEvent;
import com.logi.orderevents.VideoOrderEvent;

public class BusinessEngineTest
{
	@Test
	public void testPhysicalProductOrderEvent() {
		PhysicalProductOrderEvent orderEvent = new PhysicalProductOrderEvent();
		orderEvent.execute();
		
		assertEquals(1, orderEvent.orderEvents.size());
		assertTrue(orderEvent.orderEvents.contains("PhysicalProductOrderEvent"));
	}
	
	@Test
	public void testBookOrderEvent() {
		BookOrderEvent orderEvent = new BookOrderEvent();
		orderEvent.execute();
		
		assertEquals(1, orderEvent.orderEvents.size());
		assertTrue(orderEvent.orderEvents.contains("BookOrderEvent"));
	}
	
	@Test
	public void testActivateMembershipEvent() {
		ActivateMembershipEvent orderEvent = new ActivateMembershipEvent();
		orderEvent.execute();
		
		assertEquals(1, orderEvent.orderEvents.size());
		assertTrue(orderEvent.orderEvents.contains("ActivateMembershipEvent"));
	}

	@Test
	public void testUpgradeMembershipEvent() {
		UpgradeMembershipEvent orderEvent = new UpgradeMembershipEvent();
		orderEvent.execute();
		
		assertEquals(1, orderEvent.orderEvents.size());
		assertTrue(orderEvent.orderEvents.contains("UpgradeMembershipEvent"));
	}
	
	@Test
	public void testSendEmail_UpgradeMembershipEvent() {
		SendEmailEvent orderEvent = new SendEmailEvent(new UpgradeMembershipEvent());
		orderEvent.execute();
		
		assertEquals(2,orderEvent.orderEvents.size());
		assertTrue(orderEvent.orderEvents.contains("UpgradeMembershipEvent"));
		assertTrue(orderEvent.orderEvents.contains("SendEmailEvent"));
		
	}
	
	@Test
	public void testSendEmail_ActivateMembershipEvent() {
		SendEmailEvent orderEvent = new SendEmailEvent(new ActivateMembershipEvent());
		orderEvent.execute();
		
		assertEquals(2,orderEvent.orderEvents.size());
		assertTrue(orderEvent.orderEvents.contains("ActivateMembershipEvent"));
		assertTrue(orderEvent.orderEvents.contains("SendEmailEvent"));
		
	}
	
	@Test
	public void testAgentCommissionEvent_PhysicalProductOrderEvent() {
		AgentCommissionEvent orderEvent = new AgentCommissionEvent(new PhysicalProductOrderEvent());
		orderEvent.execute();
		
		assertEquals(2,orderEvent.orderEvents.size());
		assertTrue(orderEvent.orderEvents.contains("PhysicalProductOrderEvent"));
		assertTrue(orderEvent.orderEvents.contains("AgentCommissionEvent"));
		
	}
	
	@Test
	public void testAgentCommissionEvent_BookOrderEvent() {
		AgentCommissionEvent orderEvent = new AgentCommissionEvent(new BookOrderEvent());
		orderEvent.execute();
		
		assertEquals(2,orderEvent.orderEvents.size());
		assertTrue(orderEvent.orderEvents.contains("BookOrderEvent"));
		assertTrue(orderEvent.orderEvents.contains("AgentCommissionEvent"));
		
	}
	
	@Test
	public void testVideoOrderEvent() {
		VideoOrderEvent orderEvent = new VideoOrderEvent("Learning to Ski");
		orderEvent.execute();
		
		assertEquals(2,orderEvent.orderEvents.size());
		assertTrue(orderEvent.orderEvents.contains("VideoOrderEvent : Learning to Ski"));
		assertTrue(orderEvent.orderEvents.contains("VideoOrderEvent : The Result of the court decision in 1997"));
	}
}
