package designpattern.lsp;

import sun.net.www.http.HttpClient;

public class SecurityTransporter extends Transporter {
	private String appId;
	private String appToken;

	public SecurityTransporter(HttpClient httpClient, String appId, String appToken) {
		super(httpClient);
		this.appId = appId;
		this.appToken = appToken;
	}

	@Override
	public Response sendRequest(Request request) {
//		if (StringUtils.isNotBlank(appId) && StringUtils.isNotBlank(appToken)) {
//			request.addPayload("", appId);
//		}
//
		return super.sendRequest(request);
	}
}
