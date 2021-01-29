package org.example.algorithm.test;

import org.example.algorithm.structure.Merge;
import org.example.algorithm.structure.Quick;

import java.util.Arrays;

/**
 * 测试
 *
 * @author Lch on 2021/1/13
 */
public class QuickTest {
    public static void main(String[] args) {
        Integer [] integer= {4,3,5,1,6,2,8,9,10};
        Quick.sort(integer);
        System.out.println(Arrays.toString(integer));
    }
}
