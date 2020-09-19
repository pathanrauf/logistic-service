package com.logi.orderevents;

public class VideoOrderEvent extends OrderEvent
{
	private String videoName;
	
	private OrderEvent freeBizOrderEvent;
	
	public OrderEvent getFreeOrderEvent() {
		return freeBizOrderEvent;
	}

	public VideoOrderEvent(String videoName) {
		super();
		this.videoName = videoName;
	}

	@Override
	public void execute() {
		orderEvents.add("VideoOrderEvent : "+ videoName);
		System.out.println("VideoOrderEvent : Created Duplicate payment slip for the royalty department");
		checkApplicableFreeBiz();
	}

	private void checkApplicableFreeBiz() {
		if("Learning to Ski".equals(videoName)) {
			freeBizOrderEvent = new VideoOrderEvent("The Result of the court decision in 1997");
			freeBizOrderEvent.execute();
			orderEvents.addAll(freeBizOrderEvent.orderEvents);			
		}
	}
}
