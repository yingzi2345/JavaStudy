package SchoolTest;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        sc.close();

        // 处理其中一个数为0的情况
        if (num1.equals("0") || num2.equals("0")) {
            System.out.println(0);
            return;
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2]; // 乘积的最大长度为两数长度之和

        // 从后往前逐位相乘
        for (int i = len1 - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2;
                int sum = product + result[i + j + 1]; // 加上当前位已有的值
                result[i + j + 1] = sum % 10; // 当前位的值
                result[i + j] += sum / 10; // 进位加到前一位
            }
        }

        // 构建结果字符串（跳过前导0）
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < result.length && result[start] == 0) {
            start++;
        }
        for (int i = start; i < result.length; i++) {
            sb.append(result[i]);
        }

        System.out.println(sb.toString());
    }
}