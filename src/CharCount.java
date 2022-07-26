//Prog to print indexes of a particular character in given string.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CharCount {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please write a sentence : ");
        String str = sc.nextLine();
        System.out.print("Track which of the character ? ");
        char  ch = sc.next().charAt(0);
        List<Integer> indices = new ArrayList<Integer>();
        int p = str.indexOf(ch);
        while (p != -1){
            indices.add(str.indexOf(ch, p));
            p = str.indexOf(ch, p+1);
        }
        if(indices.isEmpty())System.out.println("Cannot find character '"+ch+"'");
        else if(indices.stream().count() == 1)  System.out.print("Character '"+ch+"' found in the index : ");
        else System.out.print("Character '"+ch+"' found in indices : ");

        for (int i: indices) {
            System.out.print(i+" ");
        }
    }
}
