package SchoolTest;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine().toLowerCase(); // 目标单词转小写
        String article = sc.nextLine();
        sc.close();

        String[] words = article.split(" ");
        int count = 0;
        int firstPos = -1;
        int currentIndex = 0; // 记录当前单词在文章中的起始位置

        for (String word : words) {
            // 检查当前单词是否与目标单词（不区分大小写）完全匹配
            if (word.toLowerCase().equals(target)) {
                count++;
                if (firstPos == -1) {
                    firstPos = currentIndex; // 记录第一次出现的位置
                }
            }
            // 更新下一个单词的起始位置（当前单词长度 + 空格1位）
            currentIndex += word.length() + 1;
        }

        if (count > 0) {
            System.out.println(count + " " + firstPos);
        } else {
            System.out.println(-1);
        }
    }
}
