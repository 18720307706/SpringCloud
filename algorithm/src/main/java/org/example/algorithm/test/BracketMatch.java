package org.example.algorithm.test;

import org.example.algorithm.structure.Stack;

/**
 * 用栈的细想解决括号问题
 *
 * @author Lch on 2021/1/25
 */
public class BracketMatch {
    public static void main(String[] args) {
        String str = "(上海(长安)())";
        boolean match = isMatch(str);
        System.out.println(str+"中的括号是否匹配："+match);
    }
    public static boolean isMatch(String str){
        Stack stack= new Stack();
        char [] chars=str.toCharArray();
        for (char aChar : chars) {
            if (aChar=='('){
                stack.push('(');
            }else if (aChar==')'){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}