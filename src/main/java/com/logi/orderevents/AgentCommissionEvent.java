package com.logi.orderevents;

public class AgentCommissionEvent extends OrderEvent
{
	private OrderEvent orderEvent;

	public AgentCommissionEvent(OrderEvent orderEvent) {
		this.orderEvent = orderEvent;
	}

	@Override
	public void execute() {
		orderEvent.execute();
		orderEvents.addAll(orderEvent.orderEvents);
		orderEvents.add("AgentCommissionEvent");
		System.out.println("AgentCommissionEvent : Generated commission payment to agent");
	}
}
