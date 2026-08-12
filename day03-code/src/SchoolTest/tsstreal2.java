package SchoolTest;

import java.util.Scanner;

public class tsstreal2 {

        // 静态内部类（模拟结构体）：封装学生数据
        static class Student {
            String id;    // 学号
            String name;  // 姓名
            int score1;   // 课程1成绩
            int score2;   // 课程2成绩
            int score3;   // 课程3成绩
            int total;    // 总分
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // 读取学生人数N
            int N = scanner.nextInt();
            scanner.nextLine(); // 吸收换行符

            // 创建学生数组（结构化存储）
            Student[] students = new Student[N];
            int sum1 = 0, sum2 = 0, sum3 = 0;
            int topIdx = 0; // 最高分学生索引

            // 录入学生数据
            for (int i = 0; i < N; i++) {
                students[i] = new Student(); // 初始化结构体对象
                String[] parts = scanner.nextLine().split(" ");

                // 给结构体成员赋值
                students[i].id = parts[0];
                students[i].name = parts[1];
                students[i].score1 = Integer.parseInt(parts[2]);
                students[i].score2 = Integer.parseInt(parts[3]);
                students[i].score3 = Integer.parseInt(parts[4]);

                // 计算总分
                students[i].total = students[i].score1 + students[i].score2 + students[i].score3;

                // 累加各科总成绩
                sum1 += students[i].score1;
                sum2 += students[i].score2;
                sum3 += students[i].score3;

                // 更新最高分学生索引
                if (students[i].total > students[topIdx].total) {
                    topIdx = i;
                }
            }

            // 输出平均成绩（空格分隔，匹配样例格式）
            System.out.printf("%d %d %d\n", sum1 / N, sum2 / N, sum3 / N);

            // 输出最高分学生数据（结构体成员直接访问）
            Student top = students[topIdx];
            System.out.printf("%s %s %d %d %d\n",
                    top.id, top.name, top.score1, top.score2, top.score3);

            scanner.close();
        }

}
