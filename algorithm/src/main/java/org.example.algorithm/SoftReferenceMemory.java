package org.example.algorithm;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用的演示
 * -Xmx20m 设置堆内存大小
 * -XX:+PrintGCDetails -verbose:gc 设置内存显示
 * java.lang.OutOfMemoryError: Java heap space堆内存不足
 * @author Lch on 2020/12/1
 */
public class SoftReferenceMemory {
    private  static  final  int _4MB=4*1024*1024;
    public static void main(String[] args) throws IOException {
//        List<byte[]> list=new ArrayList<>();
//        for (int i =0;i<5;i++){
//            list.add(new byte[_4MB]);
//        }
//        System.in.read();
        soft();
    }
    public  static  void  soft(){
        ReferenceQueue <byte[]> queue=new ReferenceQueue<>();
        List<SoftReference<byte[]>> list=new ArrayList<>();
        for (int i =0;i<5;i++){
            SoftReference<byte[]> ref=new SoftReference<>(new byte[_4MB],queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        System.out.println("循环结束："+list.size());
        Reference<?extends byte[]> poll=queue.poll();
        while (poll!=null){ //移除数组中的空的软引用 List没有移除软引用的能力,只能用引用队列 只有能被回收的软引用在引用队列中
            System.out.println(poll);
            list.remove(poll);
            poll=queue.poll();
        }
        System.out.println("移除结束："+list.size());
        for (SoftReference<byte[]>ref: list  ){//循环时会有4个null值要用引用队列移除
            System.out.println(ref.get());
        }
    }
}