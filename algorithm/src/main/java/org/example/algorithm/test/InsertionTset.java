package org.example.algorithm.test;

import org.example.algorithm.structure.Bubble;
import org.example.algorithm.structure.Insertion;

import java.util.Arrays;

/**
 * 插入排序测试
 *
 * @author Lch on 2021/1/8
 */
public class InsertionTset {
    public static void main(String[] args) {
        Integer [] integer= {4,3,5,1,6,2};
        Insertion.sort(integer);
        System.out.println(Arrays.toString(integer));
    }
}