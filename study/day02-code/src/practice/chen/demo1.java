package practice.chen;

public class demo1 {
    public static void main(String[] args) {
        //1.基本用法：
        // 定义变量，再进行输出
        int a = 10;
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        //2.变量参与计算
        int b = 30;
        int c = 20;
        System.out.println(b + c);
        //3.修改变量记录的值
        a = 50;
        System.out.println(a);

        System.out.println("---------------");

        //注意事项：
        //在一条语句中，可以定义多个变量
        int d = 100, e = 200, f = 300;
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

        //变量在使用之前必须要赋值；
        int g;
        g = 80;
        //建议：以后在定义变量的时候，直接赋值
        //不要把赋值分开写。
        System.out.println(g);

        System.out.println("=======================");

        System.out.println("小练习：公交车");
        //一开始没有乘客"
        int count = 0;
        //第一站：上来一位乘客"
        //在原有的基础上+1；
        count = count + 1;
        //"第二站：上来两位乘客，下去一位乘客"
        count = count + 2 - 1;
        //"第三站：上来两位乘客，下去一位乘客"
        count = count + 2 - 1;
        //"第四站：下去一位乘客"
        count = count - 1;
        //"第五战：上来一位乘客"
        count = count + 1;
        //"请问：到终点站后，车上一共几位乘客？"
        System.out.println(count);

        System.out.println("=============数据类型==========");

        //大小范围关系：double>float>long>int>short>byte

        //byte
        byte b1 = 10;
        System.out.println(b1);

        //short
        short s = 20;
        System.out.println(s);
        //int
        int in = 30;
        System.out.println(in);
        //long
        //如果要定义long类型的变量，
        //在数据值的后面需要加一个L作为后缀
        //建议：使用大写。
        long df = 99999999999L;
        System.out.println(df);

        //float
        //注意点：定义float类型的变量的时候
        //数据值也需要加一个F作为后缀。
        float f1 = 10.1F;
        System.out.println(f1);
        //double
        double d1 = 10.2;
        System.out.println(d1);

        //char
        char c1 = '中';
        System.out.println(c1);

        //boolean
        //true false
        boolean o = true;
        System.out.println(o);


        System.out.println("=============小练习：输出信息==========");
        //姓名
        String name = "小陈小陈啦啦啦";
        //年龄
        int age = 20;
        //性别
        char gender = '男';
        //身高
        double height = 180.1;
        //是否单身:是
        boolean flag = false;

        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(height);
        System.out.println(flag);


        System.out.println("=============小练习：输出电影信息==========");
        //需求：讲（电影名称，主演，年份，评分）四个信息选择不同类型的变量，打印在控制台
        //定义变量：记录电影名字
        String nameMovie = "送初恋回家";
        //演员
        String tostar = "小刘，小陈，小张，小高";
        //年份
        int year = 2020;
        //评分
        double grade = 9.0;

        //输出所有变量的值
        System.out.println("电影名称：" + nameMovie);
        System.out.println("演员" + tostar);
        System.out.println("上映年份" + year);
        System.out.println("评分：" + grade);


        System.out.println("=============小练习：输出手机信息==========");
        //需求：选择其中一部手机，将（手机价格，手机品牌）两个信息选择不同类型的变量，随后打印出来
        //定义变量记录手机价格
        double price = 5299.00;
        //定义变量记录手机品牌
        String namePhone = "VIVO";
        //输出结果：
        System.out.println("品牌："+namePhone);
        System.out.println("价格："+price);








    }
}
