package org.example.algorithm.structure;

import javax.xml.soap.Node;
import java.util.Iterator;

/**
 * 栈的API
 *
 * @author Lch on 2021/1/25
 */
public class Stack<T> implements  Iterable<T>{
    private Node head;
    private  int N;
    //判断栈是否为空，是返回true，否返回false
    public boolean isEmpty(){
        return  N==0;
    }
    public   Stack(){
        head=new Node(null,null);
        N=0;
    }
    //获取栈中元素的个数
    public int size(){
        return  N;
    }
    //弹出栈顶元素
    public T pop(){
        if (isEmpty()){
           return  null;
        }
        //弹出元素
        Node<T> node= head.next;
        head.next=head.next.next;
        N--;
        return node.item;
    }
    //向栈中压入元素t
    public void push(T t){
        //当前元素
        Node<T> node= new Node(t,head.next);
        //前一个元素
        head.next=node;
        N++;
    }

    public  class Node<T> {
        private   Node<T> next;
        private  T item;
        public  Node(  T item,Node next){
            this.next=next;
            this.item=item;
        }
    }
    @Override
    public Iterator iterator(){
        return new  StackIterable();
    }
    private class   StackIterable implements Iterator{
        private Node nodes;
        public  StackIterable(){
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
}