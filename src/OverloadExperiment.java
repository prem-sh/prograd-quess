public class OverloadExperiment {
    public static void main(String[] args) {
        DEF def = new DEF();
        def.method1(1);
        def.method1(1,2);
        def.method1(1,2,3);
    }
}

class ABC{
    void method1(int a) {
        System.out.println("method1("+a+")");
    }
}

class DEF extends ABC{
    void method1(int a, int b) {
        System.out.println("method1("+a+","+b+")");
    }
    void method1(int a, int b, int c) {
        System.out.println("method1("+a+","+b+","+c+")");
    }
}