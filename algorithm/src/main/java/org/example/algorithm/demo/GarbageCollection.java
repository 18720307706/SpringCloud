package org.example.algorithm.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 垃圾回收GC
 *
 * @author Lch on 2020/12/3
 */
public class GarbageCollection {
    private  static  final  int _512KB=5*1024;
    private  static  final  int _1MB=1024*1024;
    private  static  final  int _6MB=6*1024*1024;
    private  static  final  int _7MB=7*1024*1024;
    private  static  final  int _8MB=8*1024*1024;
    private  static  final  int _11MB=11*1024*1024;
    //-Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) {
        ArrayList<byte[]> list=new ArrayList<>();
//        list.add(new byte[_7MB]);
//        list.add(new byte[_512KB]);
//        list.add(new byte[_512KB]);
        //当对象足够大的时候,一开始eden区内存不够,老年代足够大的时候,会直接把这个对象晋升到老年代中,不会触发GC
        list.add(new byte[_8MB]);
        //当对象足够大的时候,一开始eden区内存不够,老年代内存也存不下的时候,会先触发GC 再触发FullGC 还是不够的话 会抛出异常java.lang.OutOfMemoryError: Java heap space
        list.add(new byte[_11MB]);
        //一个线程抛出的异常不会导致整个JAVA进程停止
    }
}