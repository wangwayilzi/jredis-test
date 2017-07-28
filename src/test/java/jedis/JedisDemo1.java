package jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *测试
 */
public class JedisDemo1 {

    /**
     * 单实例的测试
     */
    @Test
    public void demo1(){
        //设置IP地址
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.set("name","imooc");
        String value=jedis.get("name");
        System.out.println(value);
        jedis.close();
    }

    /**
     * 连接池测试
     */
    @Test
    public void demo2(){
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(10);

        JedisPool pool=new JedisPool(config,"127.0.0.1",6379);

        Jedis jedis=null;
        try {
            jedis=pool.getResource();
            jedis.set("pool","JedisPool");
            String value=jedis.get("pool");
            System.out.println(value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null)
            jedis.close();
            pool.close();
        }
    }
}
