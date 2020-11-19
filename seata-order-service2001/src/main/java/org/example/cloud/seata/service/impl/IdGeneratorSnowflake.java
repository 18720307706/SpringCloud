package org.example.cloud.seata.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 雪花算法实现类
 *
 * @author Lch on 2020/11/18
 */
@Component
@Slf4j
public class IdGeneratorSnowflake {
    private  long workerId=0;
    private  long datacenterId=1;
    private Snowflake snowflake= IdUtil.createSnowflake(workerId,datacenterId);

    /**
     * 加载完 构造方法时执行
     */
    @PostConstruct
    public  void init(){
        try {
            workerId= NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前的机器workerId:{}",workerId);

        }catch (Exception e){
            e.printStackTrace();
            log.warn("当前的机器workerId获取失败",e);
            workerId=NetUtil.getLocalhostStr().hashCode();
        }
    }
    public  synchronized  long snowflakeId(){
        return  snowflake.nextId();
    }
    public  synchronized  long snowflakeId(long workerId, long datacenterId){
        Snowflake snowflake= IdUtil.createSnowflake(workerId,datacenterId);
        return  snowflake.nextId();
    }

    public static void main(String[] args) {
        String id = String.valueOf(new IdGeneratorSnowflake().snowflakeId()) ;
        System.out.println(id);
        System.out.println("1326864901716619266".length());
    }
}