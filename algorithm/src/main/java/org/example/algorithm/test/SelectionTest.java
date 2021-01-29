package org.example.algorithm.test;

import org.example.algorithm.structure.Bubble;
import org.example.algorithm.structure.Selection;

import java.util.Arrays;

/**
 * 选择排序测试
 *
 * @author Lch on 2021/1/8
 */
public class SelectionTest {
    public static void main(String[] args) {
        Integer [] integer= {2,4,5,1,6,3,7};
        Selection.sort(integer);
        System.out.println(Arrays.toString(integer));
    }
}