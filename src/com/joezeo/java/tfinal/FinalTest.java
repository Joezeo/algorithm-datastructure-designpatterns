package com.joezeo.java.tfinal;

public class FinalTest {
    /*
        static修饰的final域，要保证在类被加载后，这个域的值被设置
     */
    public static final int CONST_TEST;
    static{
        CONST_TEST = 10;
    }

    /*
        不是static修饰的final域，要保证在类构造器执行后被设置值
     */
    public final int testInt;
    public FinalTest(){
        testInt = 10;
    }

    /*
        如果final修饰一个可变对象，这表示这个域的引用不会指向另外一个对象，但是这个对象可以改变
     */
    public final StringBuilder sb = new StringBuilder("Hello");
    public FinalTest(String s){
        this();
        sb.append(s);
    }

    public static void main(String[] args) {
        FinalTest test = new FinalTest("World");
        System.out.println(test.testInt);   //10
        System.out.println(test.sb);    //HelloWorld
    }
}
