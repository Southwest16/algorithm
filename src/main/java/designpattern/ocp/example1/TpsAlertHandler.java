package designpattern.ocp.example1;

public class TpsAlertHandler extends AlertHandler {
	public TpsAlertHandler(AlertRule rule, Notification notification) {
		super(rule, notification);
	}

	@Override
	public void check(ApiStatInfo apiStatInfo) {
		long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
//		if (tps > rule.getMatchRule(apiStatInfo.getApi()).getMaxTps()) {
//			notification.notify(NotificationEmergencyLevel.URGENCY, "");
//		}
	}
}
