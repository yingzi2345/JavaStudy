public class ChongZai {
    public static void main(String[] args) {
        //重载的定义：同一个类中，方法名相同，但参数不同的方法称为方法的重载。
        //！！参数类型顺序不同也可以构成重载，但不建议！！


        /*需求：使用方法重载的思想，设计比较两个整数是否相同的方法。
          要求：兼容全整数类型（byte，short，int，long）*/

        //调用：
        //compare(20, 30);
        //compare((byte) 10, (byte) 20);
        byte b1 = 10;
        byte b2 = 20;
        compare(b1, b2);


    }

    //把相同的功能的方法名起一样的名字
    //好处1：定义方法的时候不用记那么多的单词
    //好处2：调用方法的时候不用那么麻烦了
    public static void compare(byte b1, byte b2) {
        System.out.println("byte");
        System.out.println(b1 == b2);
    }

    public static void compare(short s1, short s2) {
        System.out.println("short");
        System.out.println(s1 == s2);
    }

    public static void compare(int i1, int i2) {
        System.out.println("int");
        System.out.println(i1 == i2);
    }

    public static void compare(long L1, long L2) {
        System.out.println("long");
        System.out.println(L1 == L2);
    }

}
