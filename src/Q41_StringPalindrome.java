import java.util.Scanner;

public class Q41_StringPalindrome {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("======= Palindrome Checker =======");
        System.out.print("Please enter a String : ");
        String inp = sc.nextLine();
        if(isPalindrome(inp)) System.out.println("\""+inp+"\" is a Palindrome");
        else System.out.println("\""+inp+"\" is not a Palindrome");
    }
    public static boolean isPalindrome(String s){
        String str = s.toUpperCase();
        char[] arr = str.toCharArray();
        int first = 0;
        int last  = arr.length-1;
        while(true){
            if(first >= last) break;
            if(arr[first]!=arr[last]){
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
}
