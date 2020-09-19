package com.logi.orderevents;

public class UpgradeMembershipEvent extends OrderEvent
{
	@Override
	public void execute() {
		orderEvents.add("UpgradeMembershipEvent");
		System.out.println("UpgradeMembershipEvent : Membership upgraded");
	}
}
