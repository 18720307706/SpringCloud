package org.example.algorithm.test;

import org.example.algorithm.structure.Bubble;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 测试排序
 *
 * @author Lch on 2021/1/8
 */
public class BubbleTest {
    public static void main(String[] args) {
         Integer [] integer= {2,4,5,1,6,3};
        Bubble.sort(integer);
        System.out.println(Arrays.toString(integer));
    }
}