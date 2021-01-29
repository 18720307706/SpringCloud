package org.example.algorithm.test;

import org.example.algorithm.structure.Merge;
import org.example.algorithm.structure.Shell;

import java.util.Arrays;

/**
 * 归并排序测试
 *
 * @author Lch on 2021/1/12
 */
public class MergeTest {
    public static void main(String[] args) {
        Integer [] integer= {4,3,5,1,6,2,8,9,10};
        Merge.sort(integer);
        System.out.println(Arrays.toString(integer));
    }
}