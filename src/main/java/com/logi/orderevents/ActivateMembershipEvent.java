package com.logi.orderevents;

public class ActivateMembershipEvent extends OrderEvent
{
	@Override
	public void execute() {
		orderEvents.add("ActivateMembershipEvent");
		System.out.println("ActivateMembershipEvent : Membership Activated");
	}

}
