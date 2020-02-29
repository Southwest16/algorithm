package designpattern.counter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConsoleReporter {
	private MetricsStorage metricsStorage;
	private ScheduledExecutorService exevutor;


	public ConsoleReporter(MetricsStorage metricsStorage) {
		this.metricsStorage = metricsStorage;
		this.exevutor = Executors.newSingleThreadScheduledExecutor();
	}

	public void startRepeatedReport(long periosInSeconds, final long durationInSeconds) {
		exevutor.scheduleAtFixedRate(new Runnable() {
			public void run() {
				long durationInMilles = durationInSeconds * 1000;
				long endTimeInMillis = System.currentTimeMillis();
				long startTimeInMillis = endTimeInMillis - durationInMilles;

				Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);

				Map<String, RequestStat> stats = new HashMap<String, RequestStat>();

				for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
					String apiName = entry.getKey();
					List<RequestInfo> requestInfoPerApi = entry.getValue();

					/*RequestStat requestStat = Aggregator.aggregate(requestInfoPerApi, durationInMilles);
					stats.put(apiName, requestStat);*/

				}

				System.out.println("");

			}
		}, 0, periosInSeconds, TimeUnit.SECONDS);
	}
}
