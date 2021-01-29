package org.example.algorithm.test;

import org.example.algorithm.structure.Stack;

/**
 * 栈的测试
 *
 * @author Lch on 2021/1/25
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for (String str : stack) {
            System.out.print(str);
        }
        System.out.println(stack.size());
        System.out.println(stack.pop());
    }
}