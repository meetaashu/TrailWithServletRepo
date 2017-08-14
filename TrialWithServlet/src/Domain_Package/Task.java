package Domain_Package;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
	
	  private final String ip;
	  private final int  monitorInterval;
	  private final int  startupDelay;
	  private final int  maxFailures;

	  public Task(String ip, Integer monitorInterval, Integer startupDelay, Integer maxFailures) {
	    this.ip = ip;
	    this.monitorInterval = monitorInterval;
	    this.startupDelay = startupDelay;
	    this.maxFailures = maxFailures;
	  }

	  @Override
	  public void run() {
	    InetAddress address = null;
	    try {
	      address = InetAddress.getByName(ip);
	    } catch (UnknownHostException e) {
	      System.out.println("IP address could not be determined:" + e.getMessage());
	    }

	    try {
	      TimeUnit.SECONDS.sleep(startupDelay);
	    } catch (InterruptedException e) {
	      return;
	    }

	    int failureCount = 0;
	    while (true) {
	      boolean reachable = false;
	      try {
	        reachable = address.isReachable(1000);
	      } catch (IOException e) {
	      }

	      if (reachable) {
	        System.out.println(ip + " is alive :^)");
	        failureCount = 0;
	      } else {
	        System.out.println(ip + " is dead :^(");
	        failureCount++;
	      }

	      if (failureCount == maxFailures) {
	        return;
	      }

	      try {
	        TimeUnit.SECONDS.sleep(monitorInterval);
	      } catch (InterruptedException e) {
	        return;
	      }

	      if (Thread.interrupted()) {
	        return;
	      }
	    }
	  }
	}
	
