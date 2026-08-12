package logicoperator;

public class demo1 {
    public static void main(String[] args) {
        //&
        //两边都为真，结果才是真。
        System.out.println(true & true);//true
        System.out.println(false & false);//false
        System.out.println(false & false);//false
        System.out.println(false & true);//false

        // |  或者
        //两边都为假，结果才是假。（有一个真，就是真）
        System.out.println("==================");
        System.out.println(true | true);//true
        System.out.println(true | false);//true
        System.out.println(false | false);//false
        System.out.println(false | true);//true

        // ^  异或
        //相同为false, 不同为true
        System.out.println("==================");
        System.out.println(true ^ true);//false
        System.out.println(true ^ false);//true
        System.out.println(false ^ false);//false
        System.out.println(false ^ true);//true

        // ! 逻辑非  取反
        //取反的感叹号不要写多次，要么不写，要么只写一次。
        System.out.println("==================");
        System.out.println(!false);//true/*
        System.out.println(!true);//false
    }
}
