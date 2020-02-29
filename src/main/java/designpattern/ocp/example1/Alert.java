package designpattern.ocp.example1;

import java.util.ArrayList;
import java.util.List;

public class Alert {
	private List<AlertHandler> alertHandlers = new ArrayList();

	public void  addAlertHandler(AlertHandler alertHandler) {
		this.alertHandlers.add(alertHandler);
	}

	public void check(ApiStatInfo apiStatInfo) {
		for (AlertHandler handler : alertHandlers) {
			handler.check(apiStatInfo);
		}
	}
}
