package org.example.algorithm.test;

import org.example.algorithm.structure.TowWayLinkList;

/**
 * 测试双向链表
 *
 * @author Lch on 2021/1/20
 */
public class TowWayLinkListTest {
    public static void main(String[] args) {
        TowWayLinkList<String> list = new TowWayLinkList<>();
        list.insert("乔峰");
        list.insert("虚竹");
        list.insert("段誉");
        list.insert(1,"鸠摩智");
        list.insert(3,"叶二娘");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("----------------------");
        String tow = list.get(2);
        System.out.println(tow);
        System.out.println("-------------------------");
        String remove = list.remove(3);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("--------------------");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        for (String str : list) {
            System.out.println(str);
        }
    }
}