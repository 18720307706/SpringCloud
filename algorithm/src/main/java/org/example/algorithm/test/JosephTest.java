package org.example.algorithm.test;

import java.util.HashMap;
import java.util.Objects;

/**
 * 约瑟夫问题
 *
 * @author Lch on 2021/1/22
 */
public class JosephTest {
    public static void main(String[] args) {
        //头结点 不能当作前一个结点来记录
        Node head=new Node(1,null);
        //记录前一个结点 要有一个变量记录前一个结点
        Node node=head;
        for (int i=2;i<42;i++){
            Node nodes=new Node(i,null);
            node.next=nodes;
            node=nodes;
        }
        node.next=head;
       joseph(head);
    }
    public  static void joseph(Node node){
        int count=1;
        Node head=node;
        //记录上一个结点 要从循环理提出来
        Node pre=head;
        while (head.next!=head){
            count++;
            if (count==3){
                //删除 当前结点
                Node cur=pre.next;
                pre.next=cur.next;
                count=1;
                System.out.println(cur.item);
            }
                pre=pre.next;
        }
    }
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
       Node next;
        public Node(T item, Node next) {
            this.item = item; this.next = next;
        }
        @Override
        public int hashCode() {
            return Objects.hash(item, next);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(item, node.item) &&
                    Objects.equals(next, node.next);
        }
    }
}