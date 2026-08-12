package SchoolTest;

public class text2 {
    public static void main(String[] args) {
        // 2、3、7 的最小公倍数为 42，直接遍历公倍数更高效
        for (int i = 42; i <= 1000; i += 42) {
            System.out.println(i);
        }
    }
}