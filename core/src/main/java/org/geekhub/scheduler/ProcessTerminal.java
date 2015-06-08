package org.geekhub.scheduler;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProcessTerminal implements ProcessTerminalMBean {

	//private final Logger log = LoggerFactory.getLogger(getClass());
	
	protected Lock lock = new ReentrantReadWriteLock().writeLock();
	
	public boolean isRunning() { return null != thread; }
	
	private long lastDurationMilis;
	public long getLastDurationMilis() { return lastDurationMilis; }
	public String getLastDuration() {
		return String.valueOf(lastDurationMilis / 1000);
	}
	
	private long startTime;
	public long getStartTime() { return startTime; }
	public Date getStartDate() { return startTime == 0 ? null : new Date(startTime); }
	
	private int timesStarted;
	public int getTimesStarted() { return timesStarted; }
	
	protected Thread thread;
	public Thread getThread() { return thread; }
	public long getThreadId() { return null == thread ? -1 : thread.getId(); }

	public String getName() { return this.job.getClass().getSimpleName(); }
	
	public ProcessTerminal(AbstractScheduler job) {
		this.job = job;
	}
	
	private AbstractScheduler job;
	public AbstractScheduler getJob() { return job; }
	public void setJob(AbstractScheduler job) { this.job = job; }
	
	private boolean schedulingOn = false;
	public synchronized boolean isSchedulingOn() { return schedulingOn;	}
	public synchronized void setSchedulingOn(boolean schedulingOn) { this.schedulingOn = schedulingOn; }
	
	public void begin() /*throws CancelProcessException*/ {
		if(thread == Thread.currentThread()) {
			lock.unlock();
			System.out.println("Running monitor was not stopped correctly last time.");
		}
		if (!lock.tryLock()) {
			System.out.println("It was forbiden to start process for thread \" + Thread.currentThread().getName()");
			throw new RuntimeException();
		}
		thread = Thread.currentThread();
		startTime = System.currentTimeMillis();
		timesStarted ++;
	}
	
	public void end() {
		if(isRunning()) {
			if(thread != Thread.currentThread()) {
				new RuntimeException("Illegal use of end method. It should be called by thread which call start method.");
			}
			thread = null;
			lastDurationMilis = System.currentTimeMillis() - startTime;
			lock.unlock();
		}
	}
	
	public Status stop() {
		if(isRunning()) {
			thread.interrupt();
			return Status.STOPING; 
		}
		return Status.NOT_RUNNING; 
	}
	
	public Status getStatus() {
		if(null == thread) {
			return Status.NOT_RUNNING;
		}
		if(thread.isInterrupted()) {
			return Status.STOPING;
		}
		return Status.RUNNING;
	}

	@Override
	public String toString() {
		return getName() + ":" + this.job.getClass();
	}
	
	private String cronExpression;
	public String getCronExpression() { return cronExpression; }
	public void setCronExpression(String cronExpression) { this.cronExpression = cronExpression; }
	
	@Override
	public String getClassName() {
		return this.job.getClass().getName();
	}
	
}
