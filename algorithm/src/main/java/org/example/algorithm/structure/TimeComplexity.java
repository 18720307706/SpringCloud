package org.example.algorithm.structure;

/**
 * 时间复杂度案例
 *
 * @author Lch on 2021/1/7
 */
public class TimeComplexity {
    public static void main(String[] args) {
        long start =System.currentTimeMillis();
        int sum =0;
        int n =100;
        for (int i=1;i<=n;i++){
            sum+=i;
        }
        System.out.println(sum);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}