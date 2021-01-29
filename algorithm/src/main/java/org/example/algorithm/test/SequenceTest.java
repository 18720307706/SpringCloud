package org.example.algorithm.test;

import org.example.algorithm.structure.SequenceList;

/**
 * 测试
 *
 * @author Lch on 2021/1/18
 */
public class SequenceTest {
    public static void main(String[] args) {
        SequenceList<String>sl = new SequenceList<>(10);
        //测试插入
//        sl.insert("姚明");
//        sl.insert("科比");
//        sl.insert("麦迪");
//        sl.insert(1,"詹姆斯");
        sl.insert(0,"张三");
        sl.insert(1,"李四");
        sl.insert(2,"王五");
        sl.insert(3,"赵六");
        // 测试获取
        String getResult=sl.get(1);
        System.out.println("获取索引1处的结果为："+getResult);
        //测试删除
        String removeResult=sl.remove(0);
        System.out.println("删除的元素是："+removeResult);
        //测试清空
//        sl.clear();
        System.out.println(sl.indexOf("詹姆斯"));
//         System.out.println("清空后的线性表中的元素个数为:"+sl.length());
        for(String s: sl ){
            System.out.println(s);
        }
    }
}