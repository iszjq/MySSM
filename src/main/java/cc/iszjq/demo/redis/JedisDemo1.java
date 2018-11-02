package cc.iszjq.demo.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis的测试
 *
 * @author zjq
 */
public class JedisDemo1 {
    @Test
    public void demo1() {
        //1.设置IP和端口
        Jedis jedis = new Jedis("112.74.56.173", 6379);
        //2.保存数据
        jedis.set("name", "zjq");
        //3.获取数据
        String value = jedis.get("name");
        System.out.println(value);
        //4.释放数据
        jedis.close();
    }

    @Test
    public void demo2() {
        //连接池设置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置最大连接数
        jedisPoolConfig.setMaxTotal(30);
        //设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "112.74.56.173", 6379);
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.set("name", "xn");
            String value = jedis.get("name");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            jedisPool.close();
        }
    }
}
