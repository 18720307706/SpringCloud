package org.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据返回类
 *
 * @author Lch on 2020/9/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{
    private  Integer code;
    private  String message;
    private  T data;
    public  CommonResult(Integer code,String message){
        this(code,message,null);
    }
}