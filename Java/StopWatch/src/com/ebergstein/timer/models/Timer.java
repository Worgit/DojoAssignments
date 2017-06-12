package com.ebergstein.timer.models;

import java.util.Date;

public class Timer {

	private Date start;
	private Date current;
	private Date stop;
	private long total;
	private double minutes;
	private double seconds;
	
	public Timer(){
		this.start = new Date(System.currentTimeMillis());
		this.current = this.start;
		this.total = 0;
		this.minutes = 0;
		this.seconds = 0;
	}
	
	public void update(){
		this.current = new Date(System.currentTimeMillis());
		this.total = this.current.getTime() - this.start.getTime();
		this.setMinutes((double) (this.total / (1000*60)) % 60);
		this.setSeconds((double) (this.total / 1000) % 60);
	}
	
	public void end(){
		this.stop = new Date(System.currentTimeMillis());
		this.total = this.stop.getTime() - this.start.getTime();
		this.setMinutes((double) (this.total / (1000*60)) % 60);
		this.setSeconds((double) (this.total / 1000) % 60);
	}
	
	public Date getStart() {
		return start;
	}
	
	public void setStart(Date start) {
		this.start = start;
	}

	public Date getCurrent() {
		return current;
	}

	public void setCurrent(Date current) {
		this.current = current;
	}

	public Date getStop() {
		return stop;
	}

	public void setStop(Date stop) {
		this.stop = stop;
	}

	public double getMinutes() {
		return minutes;
	}

	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}

	public double getSeconds() {
		return seconds;
	}

	public void setSeconds(double seconds) {
		this.seconds = seconds;
	}
	
}
