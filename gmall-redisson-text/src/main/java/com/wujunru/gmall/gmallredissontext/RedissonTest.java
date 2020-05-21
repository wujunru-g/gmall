package com.wujunru.gmall.gmallredissontext;


import com.alibaba.dubbo.common.utils.StringUtils;
import com.wujunru.gmall.utils.RedisUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

@Controller
public class RedissonTest {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    RedissonClient redissonClient;

    @RequestMapping("redisTest")
    @ResponseBody
   public String textRedisson(){
     Jedis jedis= redisUtil.getJedis(); //获得redis链接
        RLock lock= redissonClient.getLock("lock");//声明锁
        lock.lock();
        try {
            String v=jedis.get("k");
            if (StringUtils.isBlank(v)){
                v="1";
            }
            System.err.println("---->"+v);
            jedis.set("k",(Integer.parseInt(v)+1)+"");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
            lock.unlock();//释放锁
        }
      return "null" ;
  }


}
