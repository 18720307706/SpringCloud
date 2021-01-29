package org.example.algorithm.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择排序
 *
 * @author Lch on 2021/1/8
 */
public class Selection {
    public  static  void sort(Comparable[] comparables){
        for (int i=0;i<=comparables.length-2;i++){
            int minIndex=i;
            for(int j=i+1; j<comparables.length;j++){
                //比较
                if (greater(comparables[minIndex],comparables[j])){
                   minIndex=j;
                }
            }
            //交换
            exch(comparables,minIndex,i);
        }
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
