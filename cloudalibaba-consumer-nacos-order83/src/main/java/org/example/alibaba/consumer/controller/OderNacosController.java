package org.example.alibaba.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.api.entities.CommonResult;
import org.example.api.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lch on 2020/11/4
 */
@RestController
public class OderNacosController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private  String serverURL;
    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public  String getNacos(@PathVariable("id") Long id){
        return  restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }

    @GetMapping(value = "/consumer/{id}")
    @SentinelResource(value = "fallback" , fallback = "handlerFallback", blockHandler = "handler",exceptionsToIgnore = IllegalArgumentException.class)
    public CommonResult<Payment> getId(@PathVariable("id") Long id){
        CommonResult<Payment> result=restTemplate.getForObject(serverURL+"/payment/"+id,CommonResult.class,id);
        if (id==4){
            throw  new  IllegalArgumentException("非法参数");
        }else if (result.getData()==null){
            throw  new  NullPointerException("没有对应的数据");
        }
        return  result;
    }

    public  CommonResult<Payment> handlerFallback(@PathVariable Long id,Throwable throwable){
        Payment payment= new Payment(id,"null");
        return  new CommonResult(500,"这是兜底的方法,异常兜底"+throwable.getMessage(),payment);
    }

    public  CommonResult<Payment> handler(@PathVariable Long id, BlockException blockException){
        Payment payment= new Payment(id,"null");
        return  new CommonResult(502,"这是限流,限流兜底"+blockException.getMessage(),payment);
    }
}