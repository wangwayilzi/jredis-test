package jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

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
}
