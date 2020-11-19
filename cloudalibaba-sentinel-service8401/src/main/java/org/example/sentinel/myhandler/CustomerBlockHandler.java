package org.example.sentinel.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.api.entities.CommonResult;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 自定义错误
 *
 * @author Lch on 2020/11/12
 */

public class CustomerBlockHandler {

    public static   CommonResult customerBlock(BlockException blockException){
        return  new CommonResult(500,"自定义错误方法1");
    }

    public  static CommonResult customerBlock2(BlockException blockException){
        return  new CommonResult(500,"自定义错误方法2");
    }
}