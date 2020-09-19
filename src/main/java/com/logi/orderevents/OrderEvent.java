package com.logi.orderevents;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class OrderEvent
{
	public final Set<String> orderEvents = new LinkedHashSet<String>();
	
	public abstract void execute();

}
