//Declare a class name ‘A’ with some methods and one parameterised constructor.
// Derive another class ‘B’ from ‘class A’.
// In class B have some methods and parameterized constructor.
// Derive Class C from class B Demonstrate how base class parameterised constructor gets call from child class constructor
// in multilevel inheritance

import java.util.Scanner;
public class Q38_SuperExperiment {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter numbers A, B and C : ");
        C obj = new C(sc.nextInt(), sc.nextInt(), sc.nextInt());
        obj.printProperties();
    }
}

class A{
    int a;
    public A(int a){
        System.out.println("\n\nSet A => "+a);
        this.a = a;
    }
}
class B extends A{
    int b;
    public B(int a,int b){
        super(a);
        System.out.println("Set B => "+b);
        this.b = b;
    }
}
class C extends B{
    int c;
    public C(int a, int b, int c){
        super(a,b);
        System.out.println("Set C => "+c);
        this.c = c;
    }
    public void printProperties(){
        System.out.println("\n\na : "+this.a);
        System.out.println("b : "+this.b);
        System.out.println("c : "+this.c);
    }
}