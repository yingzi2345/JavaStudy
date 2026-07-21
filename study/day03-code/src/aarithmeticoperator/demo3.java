package aarithmeticoperator;

public class demo3 {
    public static void main(String[] args) {
        byte b1 = 100;
        byte b2 = 100;
        //(byte)b1+b2强转的是b1,并不是最终的结果
        byte result  = (byte)(b1+b2);
        System.out.println(result);//结果发生错误，因为要转换的数据过大。
    }
}
