package designpattern.counter;

import java.util.List;
import java.util.Map;

public interface MetricsStorage {
	void saveRequestInfo(RequestInfo requestInfo);

	List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeMillis);

	Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);

}
