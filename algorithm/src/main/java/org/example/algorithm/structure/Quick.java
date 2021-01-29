package org.example.algorithm.structure;

import java.nio.channels.Pipe;

/**
 * 快速排序API
 *
 * @author Lch on 2021/1/12
 */
public class Quick {
    public  static  void sort(Comparable[] comparables){
        int lo=0;
        int hi=comparables.length-1;
        sort(comparables,lo,hi);
    }
    public  static  void sort(Comparable[] comparables,int lo, int hi){
        if (hi<=lo){
            return;
        }
        // 获取中间分组 索引
        int partition=partition(comparables,lo,hi);
        sort(comparables,lo,partition-1);
        sort(comparables,partition+1,hi);

    }
    public  static  int partition(Comparable[] comparables,int lo,int hi){
        Comparable comparable= comparables[lo];
        int p1=lo;
        int p2=hi+1;
        while (true){
            while (greater(comparables[--p2],comparable)){
                if (p2==p1){
                    break;
                }
            }
            while (greater(comparable,comparables[++p1])){
                if (p1==p2){
                    break;
                }
            }
            if (p1>=p2){
                    break;
            }else {
                //大小位置交换
                exch(comparables,p1,p2);
            }
        }
        //中间值和第一个元素交换
        exch(comparables,lo,p2);
        return  p2;
    }
    public  static  boolean greater(Comparable a, Comparable b){
        return  a.compareTo(b)>0;
    }
    public  static  void  exch(Comparable[]a ,int i,int j){
        Comparable temp;
        temp=a[j];
        a[j]=a[i];
        a[i]=temp;
    }
}