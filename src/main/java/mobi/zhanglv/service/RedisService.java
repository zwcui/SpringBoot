package mobi.zhanglv.service;

import redis.clients.jedis.Jedis;

/**
 * Author cuizhengwei
 * Date   2018/3/7
 * Description
 */
public interface RedisService {

	public Jedis getResource();

	public void returnResource(Jedis jedis);

	public void set(String key, String value);

	public String get(String key);

}
