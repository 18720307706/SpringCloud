package org.example.algorithm.structure;

import java.util.Iterator;

/**
 * 双向链表实现
 *
 * @author Lch on 2021/1/20
 */
public class TowWayLinkList<T> implements  Iterable<T>{
    //记录首结点
    private Node first;
    //记录尾结点
    private Node last;
    //存储数据
     private  T item;
    //记录链表的长度
    private int N;


    //初始化方法
    public TowWayLinkList(){
        last=null;
        first= new Node(null,null,null);
        N=0;
    }

    //空置线性表
    public void clear(){
        //空置线性表不需要再重新new对象
        first.pre=null;
        first.item=null;
        first.next=null;
        N=0;
    }
    //判断线性表是否为空，是返回true，否返回false
    public boolean isEmpty(){
        //根据元素的个数判断
        return  N==0;
    }
    //获取线性表中元素的个数
    public int length(){
        return  N;
    }
    //读取并返回线性表中的第i个元素的值
    public T get(int i){
        //
        Node node=first;
        for (int x=0;x<=i;x++ ){
            node=node.next;
        }
        return node.item;
    }
    //往线性表中添加一个元素；
    public void insert(T t){
        if (isEmpty()){
            Node node= new Node(first,t,null);
            last=node;
            first.next=last;
        }else {
            Node oldLast=last;
            Node node= new Node(oldLast,t,null);
            oldLast.next=node;
            last=node;
        }
        N++;
    }
    //在线性表的第i个元素之前插入一个值为t的数据元素。
    public void insert(int i,T t){
        Node node=first;
        for (int x=0;x<i;x++){
            node=node.next;
        }
        //当前结点
        Node cur=node.next;
        Node newNode= new Node(node,t,cur);
        node.next=newNode;
        cur.pre=newNode;
        N++;
    }
    // public T remove(int i):删除并返回线性表中第i个数据元素。
    //返回线性表中首次出现的指定的数据元素的位序号，若不存在，则返回-1
    public int indexOf(T t){
        Node node=first;
        for (int x=0;node.next!=null;x++){
            node=node.next;
            if (node.item.equals(t)){
                return x;
            }
        }
        return  -1;
    }
    //获取第一个元素
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return  first.next.item;
    }
    //获取最后一个元素
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }
    public  T remove( int i){
        Node node=first;
        for (int x=0;x<i;x++){
            node=node.next;
        }
        //当前元素
        Node cur=node.next;
        node.next=cur.next;
        cur.next.pre=node.next;
        N--;
        return  cur.item;
    }
    private class Node{
        //记录首结点
        private Node pre;
        //记录尾结点
        private Node next;
        //存储数据
        private  T item;
        public Node(Node nodeFirs,T nodeItem,Node nodeLast ){
            this.pre=nodeFirs;
            this.item=nodeItem;
            this.next=nodeLast;
        }
    }
    @Override
    public Iterator iterator()  {
        return new TowWayLinkIterator();
    }
    public  class  TowWayLinkIterator implements  Iterator{
        private  Node node;

        public  TowWayLinkIterator(){
            this.node=first;
        }

        @Override
        public boolean hasNext() {
            return node.next!=null;
        }

        @Override
        public Object next() {
            node=node.next;
            return node.item;
        }
    }
}
