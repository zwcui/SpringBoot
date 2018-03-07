package mobi.zhanglv.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Author cuizhengwei
 * Date   2018/3/7
 * Description Redis配置类
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String host;

	private int port;

	private String password;

	private int timeout;

	private int maxActive;

	private int maxWait;

	private int maxIdle;

	private int minIdle;

	@Bean
	public JedisPoolConfig getRedisConfig(){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(maxIdle);
		config.setMinIdle(minIdle);
		config.setMaxTotal(maxActive);
		config.setMaxWaitMillis(maxWait);
		return config;
	}

	@Bean
	public JedisPool getJedisPool(){
		JedisPoolConfig config = getRedisConfig();
		JedisPool pool = new JedisPool(config,host,port,timeout,password);
		logger.info("init JredisPool ...");
		return pool;
	}

	public Logger getLogger() {
		return logger;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
}
