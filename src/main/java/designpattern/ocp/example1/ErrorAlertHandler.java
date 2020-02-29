package designpattern.ocp.example1;

public class ErrorAlertHandler extends AlertHandler {
	public ErrorAlertHandler(AlertRule rule, Notification notification) {
		super(rule, notification);
	}

	@Override
	public void check(ApiStatInfo apiStatInfo) {
//		if (apiStatInfo.getErrorCount() > rule.getMatchRule(apiStatInfo.getApi()).getMaxErrorCount) {
//			notification.notify(NotificationEmergencyLevel.SEVERE, "");
//		}
	}
}
