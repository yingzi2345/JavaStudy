package test;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        /*数字6是一个伟大的数字，键盘录入两个整数。
         * 如果其中一个为6，最终结果输出为true
         * 如果它们的和为6的倍数，最终结果输出为true
         * 其他情况都是false*/

        //录入，定义两个整数


        //a==6 || b==6 ||（a+b）%6==0

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数");
        int number1 = sc.nextInt();
        System.out.println("请输入第二个整数");
        int number2 = sc.nextInt();


        //boolean result = number1 == 6 || number2 == 6 || (number1 + number2) % 6 == 0;

        //当两个输入都是 0 时应该输出 false，即使它们的和是 6 的倍数
        boolean result;
        if (number1 == 0 && number2 == 0) {
            result = false;
        } else if (number1 == 6 || number2 == 6 || (number1 + number2) % 6 == 0) {
            result = true;
        } else {
            result = false;
        }
        System.out.println(result);
        sc.close();

    }
}
