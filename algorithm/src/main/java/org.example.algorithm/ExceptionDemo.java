package org.example.algorithm;

/**
 * 异常测试
 *
 * @author Lch on 2020/12/23
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println(demo());
    }
    public  static  int demo(){
        try {
            int i = 1/0;
            return i;
        }finally {
            return 10; // finally 中有返回值会吞噬异常 不触发异常
        }
    }
}