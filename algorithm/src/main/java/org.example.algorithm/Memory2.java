package org.example.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lch on 2020/11/26
 */
public class Memory2 {
    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<>();
        for (int i =0 ;i<200;i++){
            students.add(new Student());
        }
        Thread.sleep(10000000L);
    }
}
class Student {
    private  byte [] big = new byte[1024*1024];
}