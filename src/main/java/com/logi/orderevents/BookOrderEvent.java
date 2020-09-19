package com.logi.orderevents;

public class BookOrderEvent extends OrderEvent
{
	@Override
	public void execute() {
		orderEvents.add("BookOrderEvent");
		System.out.println("BookOrderEvent : Created Duplicate payment slip for the royalty department");
	}

}
