package org.example.algorithm.structure;

import java.util.Iterator;
import java.util.Objects;

/**
 * 顺序表的实现
 *
 * @author Lch on 2021/1/15
 */
public class SequenceList<T> implements Iterable<T> {
    // 存储元素的数据
    private  T [] eles;
    //记录当前顺序表中的元素个数
    private int N;
    //构造方法
    public  SequenceList(int capcity){
        //初始化数组0
        eles= (T[]) new Object[capcity];
    }
    //将一个线性表位置为空表
    public  void  clear(){
        //要加this
        this.N=0;
    }
    //判断线性表是否为空，是返回true，否返回false
    public boolean isEmpty(){ return  N==0; }
    //获取线性表中元素的个数
    public int length(){ return  N; }
    //读取并返回线性表中的第i个元素的值
    public T get(int i){
        return  eles[i] ;
    }
    //在线性表的第i个元素之前插入一个值为t的数据元素。
    public void insert(int i,T t){
        //插之前要进行数据扩容。
        if (N==eles.length){
            resize(2*N);
        }
        for (int x=N;x>i;x--){
            eles[x]=eles[x-1];
        }
        eles[i]=t;
        N++;
    }
    public void insert(T t){
        //插之前要进行数据扩容。
        if (N==eles.length){
            resize(2*N);
        }
        eles[N++]=t;
    }
    //扩容方法
    public  void  resize(int newSize){
        //保存原数组
        T []newList=eles;
        //创建新数组
        eles=(T[]) new Object[newSize];
        for (int i=0;i<N;i++){
            //把原来的数组值赋值
            eles[i]=newList[i];
        }
    }
    //删除并返回线性表中第i个数据元素。
    public T remove(int x){
        //删除 把i后面的元素 往前移,i前面的元素不动,只影响后面的元素
        if(x<0||x>N-1){throw new RuntimeException("当前要删除的元素不存在");}
        T rem=eles[x];
        for (int index=x;index<N-1;index++){
            eles[index]=eles[index+1];
        }
        //还要把N元素个数相减
        N--;
        if (N<eles.length/4){
            remove(eles.length/2);
        }
        return  rem;
    }
    //返回线性表中首次出现的指定的数据元素的位序号，若不存在，则返回-1。
    public int indexOf(T t){
        for (int i=0;i<N;i++){
            //不能用== 要用equals 是根据值判断的 ==是根据内存地址的
            if (eles[i].equals(t)){
                return i;
            }
        }
        return  -1;
    }
    public void showEles(){
        for(int i=0;i<N;i++){
            System.out.print(eles[i]+"");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new SequenceIterator();
    }
    private class   SequenceIterator implements  Iterator{
        //记录当前索引
        private  int cur;
        public SequenceIterator(){
            cur=0;
        }
        @Override
        public boolean hasNext() {
            return cur<N;
        }

        @Override
        public Object next() {
            return eles[cur++];
        }
    }
}