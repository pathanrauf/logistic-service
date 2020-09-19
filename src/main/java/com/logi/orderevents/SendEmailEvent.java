package com.logi.orderevents;

public class SendEmailEvent extends OrderEvent
{
	private OrderEvent orderEvent;

	public SendEmailEvent(OrderEvent orderEvent) {
		this.orderEvent = orderEvent;
	}

	@Override
	public void execute() {
		orderEvent.execute();
		orderEvents.addAll(orderEvent.orderEvents);
		orderEvents.add("SendEmailEvent");
		System.out.println("SendEmailEvent : Emailed to owner");
	}
}
