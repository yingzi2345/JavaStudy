package test;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        /*需求：
        键盘录入两个整数，表示你和你约会对象的时髦程度，（手动录入0~10之间的整数，不能录其他）
        如果你的时髦程度大于你对象的时髦程度，相亲成功！，输出true。
        否则输出false*/

        //1.键盘录入两个整数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入自己的衣服时髦程度");
        int myFashion = sc.nextInt();
        System.out.println("请输入约会对象的衣服时髦程度");
        int girlFashion = sc.nextInt();

        //2.把我和她进行对比
        boolean result = myFashion > girlFashion;

        //3.打印结果
        System.out.println(result);
    }
}
