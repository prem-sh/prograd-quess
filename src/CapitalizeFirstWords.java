import java.util.Scanner;

//Prog to capitalize first character of each word in the given string.
public class CapitalizeFirstWords {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please write a sentence : ");
        String[] str = sc.nextLine().trim().split(" ");
        for(int i=0; i< str.length; i++){
            str[i] = str[i].substring(0,1).toUpperCase()+str[i].substring(1);
        }
        System.out.println("Title Case : "+String.join(" ", str));
    }
}
