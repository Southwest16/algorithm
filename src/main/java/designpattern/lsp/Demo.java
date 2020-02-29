package designpattern.lsp;

public class Demo {
	public void demoFunc(Transporter transporter) {
		Request request = new Request();
		Response response = transporter.sendRequest(request);
	}

	public static void main(String[] args) {
		Demo demo = new Demo();
		//demo.demoFunc(new SecurityTransporter(httpClient, "", ""));
	}
}
