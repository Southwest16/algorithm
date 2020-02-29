package designpattern.counter;

import java.util.List;
import java.util.Map;

public class RedisMetricsStorage implements MetricsStorage {
	public void saveRequestInfo(RequestInfo requestInfo) {

	}

	public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeMillis) {
		return null;
	}

	public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
		return null;
	}
}
