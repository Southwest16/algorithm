package designpattern.ocp.example1;

public class TimeoutAlertHandler extends AlertHandler{
	public TimeoutAlertHandler(AlertRule rule, Notification notification) {
		super(rule, notification);
	}

	@Override
	public void check(ApiStatInfo apiStatInfo) {

	}
}
