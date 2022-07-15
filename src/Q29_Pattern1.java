//Task 29 :
//        Write a Java program to print following alphabet pattern
//        A B C D E
//        B C D E
//        C D E
//        D E
//        E
import java.util.Scanner;
public class Q29_Pattern1 {
    public static void main(String[] args) {
        System.out.print("Input number of Lines : ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            for (int j = i; j < number; j++) {
                System.out.print((char)(65+j)+" ");
            }
            System.out.println();
        }
    }
}