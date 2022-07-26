import Q39_NumberConverterCLI.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
class test{

    public static void main(String[] args) throws IOException{
        FileReader fw = new FileReader("file.statergy");
        Scanner sc = new Scanner(fw);
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }

}