package org.example.algorithm.structure;

/**
 * 插入排序法
 *
 * @author Lch on 2021/1/8
 */
public class Insertion {
    public  static  void sort(Comparable[] comparables){
       for (int i=1;i<comparables.length;i++){
            for (int j=i;j>0;j--){
                if (greater(comparables[j-1],comparables[j])){
                    exch(comparables,j-1,j);
                }else {
                      break;
                }
            }
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