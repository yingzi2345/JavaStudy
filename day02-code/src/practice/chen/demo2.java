package practice.chen;//1.导包，找到Scanner这个类在哪里
//书写要注意：要写在类定义的上面

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        //标识符：给类、方法、变量等起的名字
        System.out.println("==================键盘录入：Scanner=====================");
        //2.创建对象，表示我现在准备要用Scanner这个类
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入整数：");
        //3.接收数据
        //变量i记录了键盘录入的数据
        /*int i = sc.nextInt();

        System.out.println(i);*/


        System.out.println("==================键盘录入：练习=====================");
        //需求：键盘录入两个整数，求出他们的和并打印
        System.out.println("请输入第一个数字：");
        int number1 = sc.nextInt();

        System.out.println("请输入第二个数字：");
        //再次接收第二个数据
        int number2 = sc.nextInt();

        System.out.println("结果="+(number1+number2));
    }
}
