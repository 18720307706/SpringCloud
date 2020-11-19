package org.example.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.example.api.entities.CommonResult;
import org.example.sentinel.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lch on 2020/11/10
 */
@RestController
@Slf4j
public class SentinelController {
    @GetMapping("/testA")
    public  String testA(){
        return  "testA";
    }
    @GetMapping("/testB")
    public  String testB(){
      log.info(Thread.currentThread().getName()+"...testB");
        return  "testB";
    }
    @GetMapping("/testD")
    public  String testD(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int i=10/0;
        log.info("...testD 测试RT");
        return  "testD";
    }
    @GetMapping("/testE")
    public  String testE(){
        int i=10/0;
        log.info("...testE 测试RT");
        return  "testE";
    }
    @GetMapping("/testKey")
    @SentinelResource(value = "testKey",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "customerBlock")
    public  CommonResult testK(){
        return   new CommonResult(200,"参数要相同 太狗啦");
    }
    @GetMapping("/testKeys")
    @SentinelResource(value = "testKeys",blockHandler = "testKeyEro")
    public  String testKs(){
        return  "testKeys";
    }
    public  String testKeyEro(String p1, String p2, BlockException exception){
        return  "这可是兜底的方法呀";
    }

    /**
     * 全局兜底的方法的返回类型要和方法返回类型一样  CommonResult 一般在项目中的返回类型都是统一的
     * @return
     */
    @GetMapping("/AllEro")
    @SentinelResource(value = "AllEro",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "customerBlock2")
    public CommonResult AllEro(){
        return  new CommonResult(200,"返回成功");
    }

}