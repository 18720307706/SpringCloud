package org.example.algorithm.test;


import org.example.algorithm.structure.LinkList;

import java.util.Objects;

/**
 * 测试
 *
 * @author Lch on 2021/1/19
 */
public class LinkListTest {
    public static void main(String[] args) {
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        seven.next=first;
//        list.insert(0,"张三");
//        list.insert(1,"李四");
//        list.insert(2,"王五");
//        list.insert(3,"赵六");
//        list.insert(4,"齐七");
//        list.insert("姚明");
//        list.insert("科比");
//        list.insert("麦迪");
//        list.insert(1,"詹姆斯");
        //测试length方法
//        for(String s :list) {
//            System.out.println(s);
//        }
//        System.out.println(list.length());
//        System.out.println("-------------------");
//        //测试get方法
//        System.out.println(list.get(2));
//        System.out.println("------------------------");
//        //测试remove方法
//        String remove=list.remove(1);
//        System.out.println(remove);
//        System.out.println(list.length());
//        System.out.println("----------------");
//        list.reverse();
//        for(String s :list) {
//            System.out.println(s);
//        }
//        System.out.println(getMid(first));
        System.out.println(isCircle(first));
    }
    public static String getMid(Node<String> first) {
        Node<String> fast=first;
        Node<String> slow=first;
        //是要判断走的最快的是否到达最后一个结点不是tNode 是fast 不是跟循坏数据一样 而是根据是否是fast走到最后一个结点
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.item;
    }
    public static Boolean isCircle(Node<String> first) {
        //判断链表是否有环,有环快慢指针始终会相遇,无环则直接返回false
        Node<String> fast=first;
        Node<String> slow=first;
        //是要判断走的最快的是否到达最后一个结点不是tNode 是fast 不是跟循坏数据一样 而是根据是否是fast走到最后一个结点
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast.equals(slow)){
                return true;
            }
        }
        return false;
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(item, node.item) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(item, next);
        }
    }
}