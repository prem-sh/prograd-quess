public class ExtendAbstractClass extends A2{

    public static void main(String[] args) {
        ExtendAbstractClass ex = new ExtendAbstractClass();


    }

    @Override
    void method2() {
        System.out.println("method2 implementation");
    }
}


abstract class A1{
    abstract void method1();
}

abstract class A2 extends A1{
    @Override
    void method1() {
        System.out.println("method1 implementation");
    }

    abstract void method2();
}