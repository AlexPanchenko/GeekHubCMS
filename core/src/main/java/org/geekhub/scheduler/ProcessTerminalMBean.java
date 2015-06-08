package org.geekhub.scheduler;

import java.util.Date;

public interface ProcessTerminalMBean {

	public static enum Status {
		STOPING("Stop signal have been sent. Please, wait when thread will be stopped"),
		RUNNING("Running"),
		NOT_RUNNING("Thread is idled");

		private final String message;

		Status(String message) {
			this.message = message;
		}
		
		@Override
		public String toString() {
			return message;
		}
	}
	
	public boolean isRunning();
	public String getLastDuration();
	public Date getStartDate();
	public int getTimesStarted();
	public String getClassName();
	public Status getStatus();
	
	public Status stop();
	
}