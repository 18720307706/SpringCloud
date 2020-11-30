package org.example.algorithm;

/**
 * @author Lch on 2020/11/27
 */
// StringTable["a","b","ab"] hashtable结构,不能扩容
public class StringDemo {
    //常量池中的信息,都会被加载到运行时常量池中,这是 a b ab 都是常量池中的符合,还没有变成 java 字符串对象
    // Idc #2 会把a 符合 变成"a"字符串对象
    // Idc #3 会把b 符合 变成"b"字符串对象
    // Idc #4 会把ab  符合 变成"ab"字符串对象
    public static void main(String[] args) {
        //字符串加载为延迟成为对象 字符串池中有相同的不会重复创建
        String s1="a"; //懒惰  字符串池 入池是符号,用时才真正创建 这是懒行为
        String s2="b"; //字符串池中 （字符串虽然也在堆里 但是new的对象是在字符串外的堆里 地址不一样）
        String s3="ab"; //字符串池中
        String s4=s1+s2;
        String s5="a"+"b"; // javac 在编译期间的优化 结果已经在编译期确定为ab 不需要new StringBuilder()
        System.out.println(s3==s4); //堆 // new StringBuilder().append("a").append("b")  new String("ab")   new 出来的对象是放在堆里面的 这里存放的地址不一样
        System.out.println(s4==s5);//"a"+"b" 是常量相加之后再找的字符串 也是“ab” 找到了 不会创建新的 所以是true


        String s6 =new  String("a")+new String("b");
        String s7=s6.intern();//将这个字符串S6对象尝试放入串池中, 如果没有则放入字符串池中,如果有则不会放入 还是在s6堆中 但是会返回字符串池中的对象则s7为字符串池中的
        System.out.println(s6==s7);
    }
}