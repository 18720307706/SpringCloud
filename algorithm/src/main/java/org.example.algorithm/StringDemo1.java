package org.example.algorithm;

/**
 * 字符串
 *
 * @author Lch on 2020/11/27
 */
public class StringDemo1 {
    public static void main(String[] args) {
        String s=new String("a");
        String s2=new String("a");
        String s3=new String("a")+new String("b");
        String s4= "ab";
        s3.intern();
        System.out.println(s3==s4);
    }
}