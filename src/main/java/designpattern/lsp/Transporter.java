package designpattern.lsp;

import sun.net.www.http.HttpClient;

public class Transporter {
	private HttpClient httpClient;

	public Transporter(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public Response sendRequest(Request request) {

		return null;
	}
}
