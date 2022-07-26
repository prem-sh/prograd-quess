package Q39_NumberConverterCLI;

import Q39_NumberConverterCLI.exceptions.MenuException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    // Color constants
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\033[0;91m";
    private static final String GREEN = "\033[0;92m";
    private static final String YELLOW = "\033[0;93m";
    private static final String BLUE = "\033[0;96m";
    private static final String PURPLE = "\033[0;95m";
    private static final String CYAN = "\033[1;96m";     //High intensity
    private static final String WHITE = "\033[1;97m";    //High intensity

    private static final String RED_BACKGROUND = "\u001B[41m";
    private static final String YELLOW_BACKGROUND = "\u001B[43m";
    private static final String BLUE_BACKGROUND = "\u001B[44m";

    private static final String DEC_COLOR = BLUE;
    private static final String BIN_COLOR = GREEN;
    private static final String OCT_COLOR = PURPLE;
    private static final String HEX_COLOR = YELLOW;
    private static final String CUR_COLOR = CYAN;

    //Constants
    public static final String BIN = ConverterAPI.BIN;
    public static final String OCT = ConverterAPI.OCT;
    public static final String DEC = ConverterAPI.DEC;
    public static final String HEX = ConverterAPI.HEX;

    //Scanner
    private Scanner sc = new Scanner(System.in);
    private String convertFrom = "";  // Stores input type
    private String convertTo = "";    // Stores output type
    private String errorMessage = ""; // Stores Error messages

    //Main function
    public static void main(String[] args) {
        Main main =  new Main();
        clrscr();
        main.eventLoop();
    }

    public void eventLoop(){
        boolean showMainMenu = true;
        boolean showSubMenu = true;

        MAIN:while(true){
            //Get Input number system
            if(convertFrom.isEmpty()){
                clrscr();
                if(showMainMenu) showMenu();
                if(!errorMessage.isEmpty()) System.out.println(errorMessage);
                System.out.print(cursor());
                String inp = sc.next().trim();
                if(inp.equalsIgnoreCase("exit")||inp.equalsIgnoreCase("back")||inp.equalsIgnoreCase("b")||inp.equalsIgnoreCase("e")) {
                    clrscr();
                    break;
                } // To Exit
                else if (inp.equalsIgnoreCase("menu")||inp.equalsIgnoreCase("m")) {
                    errorMessage = "";
                    clrscr();
                    continue;                       // back to menu again
                }
                try {
                    setMenu(inp);
                } catch (MenuException e) {
                    errorMessage = "ERROR: " + e.getMessage();
                    continue;
                } finally {
                    if (!convertFrom.isEmpty()) errorMessage=""; //Clears Error buffer on successful setMenu
                }
                showMainMenu = true;
                clrscr();
            }

            //Get Output number system
            if(convertTo.isEmpty()){
                clrscr();
                if (showSubMenu) showSubMenu();
                if(!errorMessage.isEmpty()) System.out.println(errorMessage);
                System.out.print(cursor());
                String inp = sc.next().trim();
                if(inp.equalsIgnoreCase("exit")||inp.equalsIgnoreCase("e")) {
                    clrscr();
                    break;
                }  // To exit
                else if (inp.equalsIgnoreCase("back")||inp.equalsIgnoreCase("menu")||inp.equalsIgnoreCase("m")||inp.equalsIgnoreCase("b")) {
                    errorMessage = "";
                    convertFrom = "";
                    clrscr();
                    continue;                      // to Show from Main-menu
                }
                try {
                    setSubMenu(inp);
                } catch (MenuException e) {
                    errorMessage = "ERROR: " + e.getMessage();
                    continue;
                } catch (NumberFormatException e){
                    errorMessage = "ERROR: " +RED+ "Menu option should be 1..3, Please Enter valid input."+RESET;
                    continue;
                }finally {
                    if (!convertTo.isEmpty()) errorMessage=""; //Clears Error buffer on successful setSubMenu
                }
                sc.nextLine(); // clears buffer line
                showSubMenu = true;
                clrscr();
            }

            while(true){
                System.out.print(cursor());
                String input = sc.nextLine().trim();
                if(input.equalsIgnoreCase("back")||input.equalsIgnoreCase("b")){
                    convertTo = "";
                    clrscr();
                    break;
                } else if (input.equalsIgnoreCase("menu")||input.equalsIgnoreCase("m")) {
                    convertFrom = "";
                    convertTo = "";
                    clrscr();
                    break;
                } else if (input.equalsIgnoreCase("exit")||input.equalsIgnoreCase("e")) {
                    clrscr();
                    break MAIN;
                } else if (input.equalsIgnoreCase("cls")||input.equalsIgnoreCase("c")) {
                    clrscr();
                }else {
                    String[] commands = input.split(" ");
                    if(!commands[0].isEmpty()) execute(commands);
                }
            }
        }
    }

    private void execute(String[] commands){
        String operand = commands[0];

        if(operand.startsWith("0b")){
            if (Objects.equals(convertTo, BIN)) convertTo = convertFrom;
            convertFrom = BIN;
        } else if (operand.startsWith("0o")) {
            if (Objects.equals(convertTo, OCT)) convertTo = convertFrom;
            convertFrom = OCT;
        } else if (operand.startsWith("0x")) {
            if (Objects.equals(convertTo, HEX)) convertTo = convertFrom;
            convertFrom = HEX;
        } else {
            operand = signNumber(operand,convertFrom);
        }

        System.out.println("\t\t\t\t\t"+colorize(operand)+"  >>--->  "+colorize(ConverterAPI.convert(operand,convertTo),convertTo));
    }

    private void showMenu(){
        String[] arr = {DEC, BIN, OCT, HEX};
        System.out.println("================== Number converter ==================\n");
        System.out.println("COMMANDS :  "+WHITE+BLUE_BACKGROUND+"    back(b)"+"   "+YELLOW_BACKGROUND+"   menu(m)"+"   "+RED_BACKGROUND+"    exit(e)"+"    "+RESET);
        System.out.println("______________________________________________________\n");
        for(int i=0; i< arr.length;i++) System.out.println((i+1)+") "+colorize(arr[i]));
        System.out.println("\n======================================================");
        System.out.println("Select Input format from the above options (1,2,3,4)");
    }
    private void showSubMenu() {
        String[] arr = {DEC, BIN, OCT, HEX};
        String output = "";
        int j = 1;
        for(int i=0; i<4; i++){
            if(!arr[i].equalsIgnoreCase(convertFrom)) {
                output+="\n      |--> "+j+") "+ colorize(arr[i]);
                j++;
            }
        }
        System.out.println("================== Number converter ==================");
        for (int i = 0; i<= Arrays.asList(arr).indexOf(convertFrom); i++) System.out.print("\n[*] "+arr[i]);
        System.out.println(output);
        for (int i = Arrays.asList(arr).indexOf(convertFrom)+1; i<arr.length ; i++) System.out.println("[*] "+arr[i]);
        System.out.println("\n======================================================");
        System.out.println("Select Output format from the above options (1,2,3)");
    }
    private void setMenu(String option) throws MenuException {
        String fmt = option.trim();
        switch(fmt){
            case "1":
                convertFrom = DEC;
                break;
            case "2":
                convertFrom = BIN;
                break;
            case "3":
                convertFrom = OCT;
                break;
            case "4":
                convertFrom = HEX;
                break;
            default:
                throw new MenuException("Menu option should be 1..4, Please Enter valid input.");
        }
    }
    private void setSubMenu(String option) throws MenuException,NumberFormatException{
        String fmt = option.trim();
        if(convertFrom.equals(DEC)) {
            int n = Integer.parseInt(option)+1;
            fmt = String.valueOf(n);
        } else if (convertFrom.equals(BIN)) {
            int n = Integer.parseInt(option);
            if(n>=2) n+=1;
            fmt = String.valueOf(n);
        } else if (convertFrom.equals(OCT)) {
            int n = Integer.parseInt(option);
            if(n>=3) n+=1;
            fmt = String.valueOf(n);
        } else if (convertFrom.equals(HEX)) {
            int n = Integer.parseInt(option);
            if(n>=4) n+=1;
            fmt = String.valueOf(n);
        }else fmt = "";

        switch(fmt){
            case "1":
                convertTo = DEC;
                break;
            case "2":
                convertTo = BIN;
                break;
            case "3":
                convertTo = OCT;
                break;
            case "4":
                convertTo = HEX;
                break;
            case "":
                System.out.println(RED+"Something went wrong, Please Restart the application"+RESET);
            default:
                throw new MenuException("Menu option should be 1..3, Please Enter valid input.");
        }
    }
    private static void clrscr(){
        System.out.print("\033[H\033[2J");
    };
    private static String colorize(String str){
        if(str.equalsIgnoreCase(DEC)) return DEC_COLOR+str+RESET;
        else if (str.equalsIgnoreCase(BIN)||str.startsWith("0b")) return BIN_COLOR+str+RESET;
        else if (str.equalsIgnoreCase(OCT)||str.startsWith("0o")) return OCT_COLOR+str+RESET;
        else if (str.equalsIgnoreCase(HEX)||str.startsWith("0x")) return HEX_COLOR+str+RESET;
        else return DEC_COLOR+str+RESET;
    }
    private static String colorize(String str, String type){
        if(str.equalsIgnoreCase(DEC)) return DEC_COLOR+str+RESET;
        else if (type==BIN) return BIN_COLOR+str+RESET;
        else if (type==OCT) return OCT_COLOR+str+RESET;
        else if (type==HEX) return HEX_COLOR+str+RESET;
        else return DEC_COLOR+str+RESET;
    }

    private String cursor(){
        if(convertFrom.isEmpty()) return CUR_COLOR+") => "+RESET;
        if(convertTo.isEmpty()) return CUR_COLOR+"("+RESET+colorize(convertFrom)+CUR_COLOR+") => "+RESET;
        else return CUR_COLOR+"("+RESET+colorize(convertFrom)+CUR_COLOR+" -> "+RESET+colorize(convertTo)+CUR_COLOR+") => "+RESET;
    }
    private static String signNumber(String input, String type){
        switch (type){
            case BIN: return "0b"+input;
            case OCT: return "0o"+input;
            case HEX: return "0x"+input;
            default: return input;
        }
    }
}