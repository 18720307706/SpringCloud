package org.example.algorithm.structure;

import java.util.Iterator;

/**
 * 链表
 *
 * @author Lch on 2021/1/18
 */
public class LinkList<T> implements  Iterable<T>{
    //记录头结点
    private Node<T> head;
    // 记录链表的长度
     private int N;
    //空置线性表
    public void clear(){
        head.next=null;
        head.item=null;
        this.N=0;
    }
    public LinkList (){
        //初始化头结点
        head=new Node<T>(null,null);
        this.N=0;
    }
    //判断线性表是否为空，是返回true，否返回false
    public boolean isEmpty(){
        return  N==0;
    }
    //获取线性表中元素的个数
    public int length(){
        return  N;
    }
    //读取并返回线性表中的第i个元素的值
    public T get(int x){
        Node<T> node=head;
        for (int i=0;i<x;i++ ){
            node=node.next;
        }
        return  node.item;
    }
    //往线性表中添加一个元素
    public void insert(T t){
        Node<T> node= head;
        while (node.next!=null){
            node=node.next;
        }
        Node<T> newNode=new  Node<T>(t,null);
        node.next=newNode;
        //不要忘记元素+1 或-1 之后 N 元素的个数是会变的
        N++;
    }
    //在线性表的第i个元素之前插入一个值为t的数据元素。
    public void insert(int x,T t){
        Node<T> n=head;
        //先找前i的前一个结点
        for (int i=0;i<=x-1;i++){
            n=n.next;
        }
        //前一个结点下面就是当前i结点
        Node<T> pre=n.next; //当前结点
        //当新建了结点并next为当前结点pre 则当前i就为新结点了 然后n.next连接新结点
        Node<T> newNode=new Node<T>(t,pre);
        n.next=newNode;  //n不变，但是变为新创的结点next
        N++;
        //后一个结点
    }
    //删除并返回线性表中第i个数据元素
    public T remove(int x){
        Node<T> n=head;
        for (int i=0;i<=x-1;i++){
            n=n.next;
        }
        //当前元素
        Node<T> pre=n.next;
        //当前的下一个元素
        Node<T> nextNode=pre.next;
        n.next=nextNode;
        N--;
        return pre.item;
    }
    //返回线性表中首次出现的指定的数据元素的位序号，若不存在，则返回-1。
    public int indexOf(T t){
        Node<T> n=head;
        for (int i=0;i<N;i++){
            n=n.next;
           if (n.item.equals(t)){
               return  i;
           }
        }
        return -1;
    }
    //反转整个链表
    public  void  reverse(){
        if (isEmpty()){
            return;
        }
        reverse(head.next);
    }
    public  String getMid(Node<String> tNode){
        Node<String> fast=tNode;
        Node<String> slow=tNode;
        //是要判断走的最快的是否到达最后一个结点不是tNode 是fast 不是跟循坏数据一样 而是根据是否是fast走到最后一个结点
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.item;
    }
    public  Node<T> reverse(Node<T> curr){
        if (curr.next==null){
            head.next=curr;
            return curr;
        }
        //反转之后当前的结点要变成上一个结点
        Node<T> pre=reverse(curr.next);
        pre.next=curr;
        curr.next=null;
        return curr;
    }
    @Override
    public Iterator iterator() {
        return new LinkIterator();
    }

    public  class  LinkIterator implements  Iterator{

        private  Node<T> nodes;
        public  LinkIterator(){
            this.nodes=head;
        }
        @Override
        public boolean hasNext() {
            return nodes.next!=null;
        }

        @Override
        public Object next() {
            nodes=nodes.next;
            return nodes.item;
        }
    }
    //结点类
    private class  Node<T> {
        T item;
        Node<T> next;
        public  Node(T item,Node<T> next){
            this.item=item;
            this.next=next;
        }
    }
}