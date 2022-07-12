import java.util.Scanner;

//21) Find the greater between four numbers using Nested Conditional Operator.

public class Q21_GratestOfFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input four Integers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

//        int gratest = (a>b && a>c && a>d)?a:(b>c && b>d)?b:(c>d)?c:d;
        int gratest = ((a>b)?a:b) > ((c>d)?c:d)?((a>b)?a:b):((c>d)?c:d);

        System.out.println("The gratest of four is "+gratest);
    }
}
