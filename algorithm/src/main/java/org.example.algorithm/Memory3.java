package org.example.algorithm;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author Lch on 2020/11/30
 */
public class Memory3 {

    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer= ByteBuffer.allocateDirect(1024*1024*1024);
        System.out.println("分配完");
        System.in.read();
        System.out.println("开始释放");
        byteBuffer=null;
        System.gc();
        System.in.read();
    }
}