//Create any class having data member of array type of size 5. Ask 5 values to user ,Write a constructor to pass the arguments to array. Use copy constructor to create another object that will have values copied from first array and add the second object should be the square of first array.


import java.util.Arrays;
import java.util.Scanner;
public class ConstructorTest {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Please enter five numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        ArrayContainer object1 = new ArrayContainer(a,b,c,d,e);
        ArrayContainer object2 = new ArrayContainer(object1);

        System.out.println(object1);
        System.out.println(object2);

    }
}

class ArrayContainer{
    private int[] array = new int[5];
    public ArrayContainer(int a, int b, int c, int d, int e){
        array[0] = a;
        array[1] = b;
        array[2] = c;
        array[3] = d;
        array[4] = e;
    }
    public ArrayContainer(ArrayContainer arr){
        for(int i = 0; i<5; i++) array[i] = arr.array[i]*arr.array[i];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
