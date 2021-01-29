package org.example.algorithm.structure;

/**
 * 归并排序
 *
 * @author Lch on 2021/1/11
 */
public class Merge {
    private  static  Comparable [] assist;
    public  static  void sort(Comparable[] comparables){
        assist = new Comparable[comparables.length];
        //最小索引
        int lo=0;
        //最大索引
        int hi=comparables.length-1;
        sort(comparables,lo,hi);
    }
    public  static  void sort(Comparable[] comparables,int lo, int hi){
        //递归调用 先校验数据的正确性
        if (hi<=lo){
            return;
        }
        //中间变量
        int mid =lo+(hi-lo)/2;
        sort(comparables,lo,mid);
        sort(comparables,mid+1,hi);
        merge(comparables,lo,mid,hi);
    }
    public  static  void merge(Comparable[] comparables,int lo, int mid,int hi){
        int i =lo;
        int p1=lo;
        int p2=mid+1;
        while (p1<=mid&&p2<=hi){
            if (greater(comparables[p1],comparables[p2])){
                assist[i++]=comparables[p2++];
            }else {
                assist[i++]=comparables[p1++];
            }
        }
        while (p1<=mid){
            assist[i++]=comparables[p1++];
        }
        while (p2<=hi){
            assist[i++]=comparables[p2++];
        }
        for (int index=lo;index<=hi;index++){
            comparables[index]=assist[index];
        }
    }
    public  static  boolean greater(Comparable a, Comparable b){
        return  a.compareTo(b)>0;
    }
}