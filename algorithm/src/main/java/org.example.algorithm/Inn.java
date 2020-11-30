package org.example.algorithm;

/**
 * @author Lch on 2020/11/25
 */
public class Inn {
    public static void main(String[] args) {
        method1();
    }
    private static  void method1(){
        method2(1,1);
    }
    private static  int method2(int a ,int b){
        int c= a+b;
        return c ;
    }
}