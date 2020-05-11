/*
package com.wujunru.gmall.manage.service.impl;

public class look {
    */
/**
     * @Description: TODO
     * @Author: 潘星宇 xingyu.pan@luckincoffee.com
     * @Date: 2020/4/01 14:57 PM
     *//*

    @Aspect
    @Component
    @Order(99)
    public class DistributeLockAspect {

        private Logger logger = LoggerFactory.getLogger(DistributeLockAspect.class);


        @Autowired
        private StringRedisTemplate stringRedisTemplate;

        @Autowired
        private AnnotationResolver annotationResolver;

        */
/**
         * execution(* com.ruoyi..*.*(..))
         *       execution（） 表达式的主体
         *       第一个 * 符号 表示返回值的类型，* 代表所有返回类型
         *       cn.itweknow.sbaop.controller AOP 所切的服务的包名，即需要进行横切的业务类
         *       包名后面的 .. 表示当前包及子包
         *       第二个 * 表示类名，* 表示所有类
         *       最后的 .*(..) 第一个 . 表示任何方法名，括号内为参数类型，.. 代表任何类型参数
         *//*

        @Pointcut("execution(* com.ruoyi..*.*(..))")
        public void distribute() {}


        */
/**
         * 在切面中使用的通知类型为 @Around，在切点之前我们先尝试获取锁，若获取锁失败则直接返回错误信息，
         * 若获取锁成功则执行方法体，当方法结束后（无论是正常结束还是异常终止）释放锁。
         * @param joinPoint
         * @param distributeLock
         * @return
         * @throws Exception
         *//*

        @Around(value = "distribute() && @annotation(distributeLock)")
        public Object doAround(ProceedingJoinPoint joinPoint, DistributeLock distributeLock) throws Throwable {
            String key = annotationResolver.resolver(joinPoint, distributeLock.key());
            System.err.println("解析得到的锁的key是：" + key);
            String keyValue = getLock(key, distributeLock.timeout(), distributeLock.timeUnit());
            if (StringUtil.isNullOrEmpty(keyValue)) {
                // 获取锁失败。
                //return BaseResponse.addError(ErrorCodeEnum.OPERATE_FAILED, "请勿频繁操作");
                throw new RuntimeException("请勿频繁操作");
            }
            // 获取锁成功
            try {
                return joinPoint.proceed();
            } finally {
                // 释放锁。
                unLock(key, keyValue);
            }
        }


        */
/**
         * RedisStringCommands.SetOption.SET_IF_ABSENT 实际上是使用了 setNX 命令，
         * 如果 key 已经存在的话则不进行任何操作返回失败，如果 key 不存在的话则保存 key 并返回成功，
         * 该命令在成功的时候返回 1，结束的时候返回 0。我们随机产生了一个 value 并且在获取锁成功的时候返回出去，
         * 是为了在释放锁的时候对该值进行比较，这样可以做到解铃还须系铃人，由谁创建的锁就由谁释放。同时还指定了
         * 超时时间，这样可以保证锁释放失败的情况下不会造成接口永远不能访问。
         * 获取锁
         * @param key       锁的key
         * @param timeout   锁超时时间
         * @param timeUnit  时间单位
         *
         * @return 锁的值
         *//*

        private String getLock(String key, long timeout, TimeUnit timeUnit) {
            try {
                String value = UUID.randomUUID().toString();
                Boolean lockStat = stringRedisTemplate.execute
                        (
                                (RedisCallback<Boolean>) connection ->
                                        connection.set
                                                (
                                                        key.getBytes(Charset.forName("UTF-8")),
                                                        value.getBytes(Charset.forName("UTF-8")),
                                                        Expiration.from(timeout, timeUnit),
                                                        RedisStringCommands.SetOption.SET_IF_ABSENT
                                                )
                        );

                if (!lockStat) {
                    // 获取锁失败。
                    System.err.println("获取锁失败。");
                    return null;
                }
                System.err.println("获取锁success。返回的value是：" + value);
                return value;
            } catch (Exception e) {
                logger.error("获取分布式锁失败，key={}", key, e);
                return null;
            }
        }

        */
/**
         * 释放锁
         *
         * @param key    锁的key
         * @param value  获取锁的时候存入的值
         *//*

        @SuppressWarnings("all")
        private void unLock(String key, String value) {
            try {
                String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
                boolean unLockStat = stringRedisTemplate.execute
                        (
                                (RedisCallback<Boolean>) connection ->
                                        connection.eval
                                                (
                                                        script.getBytes(), ReturnType.BOOLEAN, 1,
                                                        key.getBytes(Charset.forName("UTF-8")),
                                                        value.getBytes(Charset.forName("UTF-8"))
                                                )
                        );
                if (!unLockStat) {
                    logger.error("释放分布式锁失败，key={}，已自动超时，其他线程可能已经重新获取锁", key);
                }
            } catch (Exception e) {
                logger.error("释放分布式锁失败，key={}", key, e);
            }
        }

    }
}
*/
