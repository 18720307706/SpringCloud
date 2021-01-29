package org.example.algorithm.structure;

/**
 * 希尔排序
 *
 * @author Lch on 2021/1/11
 */
public class Shell {
    public  static  void sort(Comparable[] comparables){
        int h=1;
        while (h<comparables.length/2){
            h=2*h+1;
        }
        while (h>=1){
            //
            for (int i=h;i<comparables.length;i++){
                for (int j=i; j>=h;j-=h){
                    if (greater(comparables[j-h],comparables[j])){
                        exch(comparables,j-h,j);
                    }else {
                        break;
                    }
                }
            }
            h=h/2;
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