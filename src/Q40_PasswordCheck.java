//Task 40 : Write a java program that let the user choose his/her username and password.
// The program verifies whether the chosen username and password are valid.
// If either one of them is invalid, it notifies the user by raising exception and explain the cause of invalidity.
// The rules for choosing valid usernames and passwords are:
//
//        a. A username must be of length 6-15 characters.
//        b. A username must start with an uppercase English alphabet A to Z.
//        c. A password must not be shorter than 8 characters but must not exceed 256.
//        d. There cannot be any types of parentheses or whitespaces in a valid username or password.
//        e. A password cannot contain or be the same as its associated username

import java.util.Scanner;
public class Q40_PasswordCheck {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean usernameOk = false;
        boolean passwordOk = false;

        String username = "" ;
        String password = "" ;
        do{ //checkingy username
            try{
                System.out.print("Username : ");
                username = sc.nextLine();
                verifyUsername(username);
                usernameOk = true;
            }catch (LoginExceptions e) {
                System.out.println(e.getMessage());
            }
        }while (!usernameOk);

        do{//Chyeckingy password
            try{
                System.out.print("Password : ");
                password = sc.nextLine();
                verifyPassword(password, username);
                passwordOk = true;
            }catch (LoginExceptions e) {
                System.out.println(e.getMessage());
            }
        }while (!passwordOk);

        System.out.println("\n=====================");
        System.out.println("Username : "+username);
        System.out.println("Password : "+password);
        System.out.println("======================");

    }

    private static void verifyUsername(String username) throws UsernameFormatException {
        //A username must be of length 6-15 characters.
        if(!(username.length() >= 6 && username.length() <= 15)){
            throw new UsernameFormatException("Username should have 6 to 15 characters");
        }
        //A username must start with an uppercase English alphabet A to Z
        else if (!(username.charAt(0)>='A' && username.charAt(0)<='Z')) {
            throw new UsernameFormatException("First letter of username should be Uppercase (A..Z)");
        }
        //
        if (checkSpecialCharecters(username)){
            throw new UsernameFormatException("Username should not have spaces and brackets");
        }
        return;
    }
    private static void verifyPassword(String password, String username) throws PasswordSecurityException,PasswordFormatException{

        //A password must not be shorter than 8 characters but must not exceed 256.
        if(!(password.length() >= 8)){
            throw new PasswordSecurityException("Password should have at least 8 characters");
        } else if(!(password.length() <= 256)){
            throw new PasswordSecurityException("Password should not exceed 256 characters");
        }
        //A password cannot contain or be the same as its associated username
        if (password.toLowerCase().contains(username.toLowerCase())){
            throw new PasswordSecurityException("Password should not contain username, It makes your password weaker");
        }
        if (checkSpecialCharecters(password)){
            throw new PasswordFormatException("Passwords should not have spaces and brackets");
        }
        return;
    }

    private static boolean checkSpecialCharecters(String str) {
        String specials = " {}[]()<>";
        for (char i:specials.toCharArray()) {
            if(str.contains(String.valueOf(i))){
                return true;
            }
        }
        return false;
    }
}

class LoginExceptions extends Exception{

    protected static final String RESET = "\u001B[0m";
    protected static final String ERROR = "\033[1;91m";

    //constructor
    public LoginExceptions(String message) {
        super(message);
    }

}

class PasswordSecurityException extends LoginExceptions{
    public PasswordSecurityException(String message) {
        super("\n"+ERROR+"PasswordSecurityException: "+RESET+message+"\n");
    }
}

class PasswordFormatException extends LoginExceptions{
    public PasswordFormatException(String message) {
        super("\n"+ERROR+"PasswordFormatException: "+RESET+message+"\n");
    }
}

class UsernameFormatException extends LoginExceptions{
    public UsernameFormatException(String message) {
        super("\n"+ERROR+"UsernameFormatException: "+RESET+message+"\n");
    }
}