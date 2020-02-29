package designpattern.isp;

public class Application {
	private static ConfigSource configSource = new ZookeeperConfigSource();
	public static final RedisConfig redisConfig = new RedisConfig(configSource);

	public static void main(String[] args) {
		ScheduledUpdater redisConfigUpdater = new ScheduledUpdater(300, 300, redisConfig);



		SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0.0.1", 8080);
		simpleHttpServer.addViewers("/config", redisConfig);
	}
}
