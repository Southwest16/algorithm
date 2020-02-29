package designpattern.isp;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledUpdater {
	private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	private long initialDelaySeconds;
	private long periodInSeconds;
	private Updater updater;


	public ScheduledUpdater(long initialDelaySeconds, long periodInSeconds, Updater updater) {
		this.initialDelaySeconds = initialDelaySeconds;
		this.periodInSeconds = periodInSeconds;
		this.updater = updater;
	}

	public void run() {
		executor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				updater.update();
			}
		}, this.initialDelaySeconds, this.periodInSeconds, TimeUnit.SECONDS);
	}
}
