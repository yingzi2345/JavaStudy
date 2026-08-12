package SchoolTest;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y;
        if (x < 1) {
            y = x;
        } else if (x >= 1 && x < 10) {
            y = 2 * x - 1;
        } else {
            y = 3 * x - 11;
        }
        // 保留两位小数输出
        System.out.printf("%.2f", y);
        scanner.close();
    }
}