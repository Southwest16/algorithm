package designpattern.isp;

import java.util.Map;

public class RedisConfig implements Updater, Viewer {
	private ConfigSource configSource; //配置中心(比如Zookeeper)
	private String address;
	private int timeout;
	private int maxTotal;

	public String getAddress() {
		return address;
	}

	public int getTimeout() {
		return timeout;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public RedisConfig(ConfigSource configSource) {
		this.configSource = configSource;
	}

	public void update() {
		//从configSource加载配置到address/timeout/maxTotal
	}

	@Override
	public String outputInPlainText() {
		return null;
	}

	@Override
	public Map<String, String> output() {
		return null;
	}
}
