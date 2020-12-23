package org.example.algorithm;

import javax.sound.midi.Soundbank;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 弱引用演示
 *
 * @author Lch on 2020/12/1
 */
public class WeakReferenceMemory {
    private  static  final  int _4MB=4*1024*1024;
    public static void main(String[] args) {
        List<WeakReference<byte[]>> list=new ArrayList<>();
        for (int i=0;i<5;i++){
            WeakReference<byte[]> ref= new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> weakReference:list){
                System.out.println(weakReference.get());
            }
            System.out.println();
        }
        System.out.println("循环结束："+list.size());
    }
}