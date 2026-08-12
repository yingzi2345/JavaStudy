package logicoperator;

public class demo2 {
    public static void main(String[] args) {
        //  && 短路与
        //两边都为真，结果才是真
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && false);
        System.out.println(false && true);

        System.out.println("-----------------------");

        //  || 短路或
        //两边都为假，结果才是假，有一个真，结果就是真
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || false);
        System.out.println(false || true);


        System.out.println("-----------------------");

        //短路逻辑运算符具有短路效果
        //简单理解：左边的表达式能确定最终的结果，那么右边就不会参与运行了
        int a = 10;
        int b = 10;
        boolean result = ++a < 5 && ++b < 5;
        System.out.println(result);//false
        System.out.println(a);//11
        System.out.println(b);//10
    }
}
