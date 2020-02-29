package designpattern.ocp.example1;

public class Demo {
	public static void main(String[] args) {
		ApiStatInfo apiStatInfo = new ApiStatInfo();
		apiStatInfo.setTimeoutCount(100);
		ApplicationContext.getInstance().getAlert().check(apiStatInfo);
	}
}
