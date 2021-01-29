package org.example.algorithm.test;

import org.example.algorithm.structure.Insertion;
import org.example.algorithm.structure.Shell;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author Lch on 2021/1/11
 */
public class ShellTest {
    public static void main(String[] args) {
        Integer [] integer= {4,3,5,1,6,2,8,9,10};
        Shell.sort(integer);
        System.out.println(Arrays.toString(integer));
    }
}