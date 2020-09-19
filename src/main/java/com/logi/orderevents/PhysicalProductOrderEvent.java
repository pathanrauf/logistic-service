package com.logi.orderevents;

public class PhysicalProductOrderEvent extends OrderEvent
{
	@Override
	public void execute() {
		orderEvents.add("PhysicalProductOrderEvent");
		System.out.println("PhysicalProductOrderEvent : Created Duplicate payment slip for shipping");
	}
}
