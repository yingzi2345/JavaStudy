import java.util.regex.Pattern;

public class zhengze {
    public static void main(String[] args) {
        String reg = "(0[1-9]|[12]\\d|3[01])";
        Pattern pattern = Pattern.compile(reg);

        //测试用例：
        String[] testArr = {
                "01", "09",  // 分支1 0[1-9]
                "10", "29",  // 分支2 [12]\\d
                "30", "31",  // 分支3 3[01]
                "00", "32", "39", // 非法
                "1", "5", "a1" // 长度不对、包含字母
        };
        for (String s :testArr){
            boolean match = pattern.matcher(s).matches();
            System.out.printf("【%s】 %s%n", s, match ? "✅ 匹配成功" : "❌ 匹配失败");
        }
    }
}
