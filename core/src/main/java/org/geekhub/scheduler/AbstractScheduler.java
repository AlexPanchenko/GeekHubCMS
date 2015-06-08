package org.geekhub.scheduler;


import java.util.concurrent.ExecutionException;

public abstract class AbstractScheduler {

    //protected static Logger log = LoggerFactory.getLogger(AbstractScheduler.class);

    protected ProcessTerminal processTerminal = new ProcessTerminal(this);

    public ProcessTerminal getProcessTerminal() {
        return processTerminal;
    }

    public AbstractScheduler() {
        processTerminal.setSchedulingOn(this.schedulingOn);
    }

    private boolean schedulingOn = true;
    public synchronized boolean isSchedulingOn() { return schedulingOn;	}
    public synchronized void setSchedulingOn(boolean schedulingOn) {
        this.schedulingOn = schedulingOn;
        processTerminal.setSchedulingOn(this.schedulingOn);
    }

    protected boolean loggingTurnedOn() {
        return true;
    }

    public abstract void schedule();

    protected void runByScheduler() {
        if (!this.schedulingOn) {
            System.out.println("Skipping run because job is disabled");
            return;
        } else {
            this.run();
        }
    }

    //@Autowired
    //private EntityManagerFactory entityManagerFactory;
    /*
     * Methods invoked by scheduler or manually
     */
    public void run() {
        try {
            if (processTerminal.isRunning()) {
                System.out.println("Can't start. Already Running..");
                return;

            }
            Thread.currentThread().setName(getClass().getCanonicalName());
            try {
                processTerminal.begin();
                process();
            } finally {
                processTerminal.end();
                if (loggingTurnedOn()) {
                    System.out.println("FINISHED");
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    /**
     * The final method for implementation in end class
     */
    protected abstract void process() throws InterruptedException, ExecutionException;

}
