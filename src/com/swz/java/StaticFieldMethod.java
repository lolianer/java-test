package com.swz.java;

/**
 * 这个类测试的是
 * 父类子类之间的  普通的、静态的  成员变量、方法
 * 会不会重写，会不会覆盖，如何用子类调用父类的重名方法等
 *
 *普通的成员变量：可以继承，没有重写（多态）
 *      这个成员变量在子类中没有重名的：
 *          每个对象一份，父类声明的变量，子类的对象中也有一份，子类中this.变量和super.变量都是一个来自父类给子类对象的同一个地址的变量
 *          所以father.变量  和  son.变量 出来的一定不是同一个对象
 *      这个成员变量在子类中有重名的
 *          Father son = new Son()，son.变量  是指向父类的中定义的变量，并不会出现“重写”的情况
 *      除了私有的变量没有给子类，都是可以通过super找到父类的变量的
 *      子类有同名的变量时，变量和父类的同时存在，用this就可以找到子类的变量，如果没有同名，就找到的是父类的变量
 *
 *
 * 静态的成员变量:可以继承，没有重写
 *      这个成员变量在子类中没有重名的：
 *          子类的对象也可以操控这块内存空间。但是子类并没有继承父类中static修饰的变量和方法。因为static修饰的变量和方法是属于父类本身的。
 *          子类也可以使用这个静态变量，Son.b是合法的，且有值
 *      这个成员变量在子类中有重名的
 *          父类的变量 和 子类的变量 可以共存，各自可以用各自的变量
 *
 * 普通的方法:可以继承，可以重写
 *      这个方法在子类中没有重名的：
 *              子类可以调用父类的方法，父类和子类的每个对象都有这个方法，所以用this 和 super都是同一个地址的方法
 *      这个方法在子类中有重名的：
 *              子类重写了父类的方法，son.方法是自己定义的方法，super.方法是父类的方法
 *
 *
 * 静态的方法:可以继承，没有重写   和静态的成员变量是一样的情况
 *      这个方法在子类中没有重名的：
 *      这个方法在子类中有重名的：
 *
 * super不是指父类的对象，super的意义就在于  在子类方法中，可以获取到父类声明的变量或者方法，即使在子类已经有了同名的方法的情况下
 *
 *
 * @author shen_wzhong
 * @create 2022-04-07 17:19
 */
public class StaticFieldMethod {
    public static void main(String[] args) {
        /*
        用父类的对象，子类的对象，父类的引用指向子类对象
        分别测试
        用父类的对象找变量和方法都是父类的
        用子类的对象找
         */
        Father father = new Father();       //父类对象
        Son son = new Son();                //子类对象
        Father s = new Son();               //用多态的形式创建子类的对象

        son.method5();

        /*

         */
        System.out.println(father.a);//Father初始普通a
        System.out.println(father.b);//Father初始静态b
        System.out.println(father.c);//Father初始普通c
        System.out.println(father.d);//Father初始静态d
        System.out.println();
        System.out.println(son.a);           //Son初始普通a
        System.out.println(son.b);           //Son初始静态b
        System.out.println(son.c);           //Father初始普通c
        System.out.println(son.d);           //Father初始静态d
//        System.out.println(son.e);           //
        System.out.println();
        System.out.println(s.a);           //Father初始普通a
        System.out.println(s.b);           //Father初始静态b
        System.out.println(s.c);           //Father初始普通c
        System.out.println(s.d);           //Father初始静态d
        System.out.println();

        father.method1();           //Father的method1普通方法
        father.method2();           //Father的method2静态方法
        father.method3();           //Father的method3普通方法
        father.method4();           //Father的method4静态方法
        System.out.println();
        son.method1();           //Son的method1普通方法
        son.method2();           //Son的method2静态方法
        son.method3();           //Father的method3普通方法
        son.method4();           //Father的method4静态方法
        System.out.println();
        s.method1();           //Son的method1普通方法
        s.method2();           //Father的method2静态方法
        s.method3();           //Father的method3普通方法
        s.method4();           //Father的method4静态方法


    }
}

class Father {
    String a = new String("Father初始普通同名a");         //普通变量，子类有同名变量
    static String b = new String("Father初始静态同名b");  //静态变量，子类有同名变量
    String c = new String("Father初始普通c");         //普通变量，子类没有同名变量
    static String d = new String("Father初始静态d");  //静态变量，子类没有同名变量
    private String e = new String("Father初始e");


    public void method1() {                     //普通方法，子类有同名方法
        System.out.println("Father的method1普通同名方法");
    }

    public static void method2() {              //静态方法，子类有同名方法
        System.out.println("Father的method2静态同名方法");
    }

    public void method3() {                     //普通方法，子类没有同名方法
        System.out.println("Father的method3普通方法");
    }

    public static void method4() {              //静态方法，子类没有同名方法
        System.out.println("Father的method4静态方法");
    }
}

class Son extends Father {
    String a = new String("Son初始普通同名a");
    static String b = new String("Son初始静态同名b");

    public void method1() {
        System.out.println("Son的method1普通同名方法");
    }

    public static void method2() {
        System.out.println("Son的method2静态同名方法");
    }

    public void method5() {                     //子类独有的方法，测试
        /*
        子类中调用父类的情况
         */
        /*
        除了私有的变量没有给子类，
        都是可以通过super找到父类的变量的
         */
        System.out.println(super.a);    //Father初始普通a
        System.out.println(super.b);    //Father初始静态b
        System.out.println(super.c);    //Father初始普通c
        System.out.println(super.d);    //Father初始静态d
//        System.out.println(super.e);    //
        System.out.println();
        /*
        子类有同名的变量时，变量和父类的同时存在，用this就可以找到子类的变量，如果没有同名，就找到的是父类的变量
         */
        System.out.println(this.a);    //Son初始普通a
        System.out.println(this.b);    //Son初始静态b
        System.out.println(this.c);    //Father初始普通c
        System.out.println(this.d);    //Father初始静态d
//        System.out.println(this.e);    //
        System.out.println();
        /*
        在子类中调用父类的方法 和 调用变量是一样的
         */
        super.method1();    //Father的method1普通方法
        super.method2();    //Father的method2静态方法
        super.method3();    //Father的method3普通方法
        super.method4();    //Father的method4静态方法
        System.out.println();
        this.method1();    //Son的method1普通方法
        this.method2();    //Son的method2静态方法
        this.method3();    //Father的method3普通方法
        this.method4();    //Father的method4静态方法

    }

}

