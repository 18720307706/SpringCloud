package org.example.algorithm.structure;

/**
 * 冒泡Api
 *
 * @author Lch on 2021/1/8
 */
public class Bubble {
    public  static  void sort(Comparable[] comparables){
        for (int i=comparables.length-1;i>0;i--){
                for(int j=0; j<i;j++){
                    if (greater(comparables[j],comparables[j+1])){
                        exch(comparables,j,j+1);
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