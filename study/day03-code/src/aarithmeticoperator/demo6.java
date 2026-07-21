package aarithmeticoperator;

public class demo6 {
    public static void main(String[] args) {
        int x = 10;
        //后++，先用后加
        //先将x变量中的值拿出来用，赋值给y，然后再自增。
        //先赋值，再++
        int y = x++;
        //先++，先加后用
        //先把x进行自增，然后把自增后的结果赋值给左边的变量
        int z = ++x;

        System.out.println("x:"+x);//12
        System.out.println("y:"+y);//10
        System.out.println("z:"+z);//12
    }
}
