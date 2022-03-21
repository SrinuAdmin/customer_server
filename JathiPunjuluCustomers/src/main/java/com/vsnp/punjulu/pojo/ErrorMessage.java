package com.vsnp.punjulu.pojo;

public class ErrorMessage {

	String errroMessage;
	String timeStamp;
	String status;

	public ErrorMessage(String errroMessage, String timeStamp, String status) {
		this.errroMessage = errroMessage;
		this.timeStamp = timeStamp;
		this.status = status;
	}
	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public void setErrroMessage(String errroMessage) {
		this.errroMessage = errroMessage;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
