package mobi.zhanglv.service.impl;

import mobi.zhanglv.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Author cuizhengwei
 * Date   2018/3/7
 * Description redis实现
 */
@Service
public class RedisServiceImpl implements RedisService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JedisPool jedisPool;

	/**
	 * 获取redis实例
	 * @return
	 */
	@Override
	public Jedis getResource() {
		return jedisPool.getResource();
	}

	/**
	 * 释放redis资源
	 * @param jedis
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void returnResource(Jedis jedis) {
		if(jedis != null){
			jedisPool.returnResourceObject(jedis);
		}
	}

	/**
	 * 释放redis资源
	 * 获取连接失败时，应该返回给pool,否则每次发生异常将导致一个jedis对象没有被回收。
	 * @param jedis
	 */
	@SuppressWarnings("deprecation")
	public void returnBrokenResourceObject(Jedis jedis) {
		if(jedis != null){
			jedisPool.returnBrokenResource(jedis);
		}
	}

	@Override
	public void set(String key, String value) {
		Jedis jedis=null;
		try{
			jedis = getResource();
			jedis.set(key, value);
			logger.info("Redis set success - " + key + ", value:" + value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + value);
			returnBrokenResourceObject(jedis);
		}finally{
			returnResource(jedis);
		}
	}

	@Override
	public String get(String key) {
		String result = null;
		Jedis jedis=null;
		try{
			jedis = getResource();
			result = jedis.get(key);
			logger.info("Redis get success - " + key + ", value:" + result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + result);
			returnBrokenResourceObject(jedis);
		}finally{
			returnResource(jedis);
		}
		return result;
	}

}
