//Task 36 :   Write a menu driven program for array. Provide choice to
// insert, delete, search, display and exit

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Q36_ArrayCLI {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        AbstractArray arrayStack[] = new AbstractArray[10]; // hosts arrays
        String arrayNames[] = new String[10]; // arrays names
        CommandEngine cmd = new CommandEngine(arrayStack, arrayNames);  // commands handler
        System.out.println("Use 'help' command to explore");
        System.out.print(" >> ");
        boolean exit = false;
        do {  // command loop
            String baseCommand = input.nextLine();
            baseCommand = baseCommand.trim().replaceAll("\\s{2,}", " ");
            String[] commandLets = baseCommand.split(" ");
//            for (String i : commandLets) System.out.print(i+" ");

            if(commandLets[0].equalsIgnoreCase("exit")) exit = true;
            else cmd.execute(commandLets);
        }while (!exit);
    }

}

class CommandEngine{
    static Scanner input = new Scanner(System.in);
    private String history[];
    private AbstractArray arrayStack[];
    private String arrayNames[];
    private String status;
    private int selected = -1;
    private int top = -1;
    private String help = """ 
        ===================== General commands =======================
        
        -> help
        -> help <command>
        -> create <array-name> <Type char or int or long or float or double or string>
        -> delete <array-name>
        -> checkout <array-name>
        -> exit
        
        ===================== Array operations =======================
        
        -> insert <value> <position>                  -> length
        
        -> remove <value>                             -> sort
        -> remove -p <position>                       -> sort <direction>
                                                      -> sort <from> <direction>
        -> pop                                        -> sort <from> <to> <direction>
        -> push        
        -> enque                                      -> find <value>
        -> deque
        
        -> show
        -> show *
        -> show <array-name> 
        
        NOTES : 
        i ) <form> and <to> are position (1..n) not index (0..n), 
            and it can be negative to represent position from last.
            EXAMPLE : remove -p -1 #removes last element from array.
            
        ii) <direction> must be -1 (decending) or 1 (ascending). 
        
        iii) use 'help <command>' to learn about individual commands.
        ==============================================================
""";

    private final String showHelp = """
        
        show               # Displays currently selected array  
        show *             # Displays all available array  
        show <array-name>  # Displays mentioned array | useful for lookup 
                           |_ another array while being on other array
        
        INFO : 
        Show can be used to view the array.
""";
    private final String findHelp = """
        
        find <value>
        
        INFO:
        This command is useful for lookup the position of the element passed.
""";
    private final String sortHelp = """
        
        sort
        sort <direction>
        sort <from> <direction>
        sort <from> <to> <direction>
        
        Example:
        
        let, arr[1,2,3,4,5,6,7]
        sort -1       >>>--> arr[7,6,5,4,3,2,1]
        sort 3 -2 1   >>>--> arr[7,(2,3,4,5,6),1]
        sort -2 1     >>>--> arr[7,2,3,4,5,(1,6)]
        sort          >>>--> arr[1,2,3,4,5,6,7]
        
        INFO :
        <direction> takes 1 or -1, 
             -1 - DESCENDING ORDER
              1 - ASCENDING ORDER
        <from> and <to> are positions (not indexes) which can be 
        either positive or negative integers.
""";
    private final String removeHelp = """
        
        remove <value>         # Remove by value
        remove -p <position>   # Remove by position
        
        INFO :
        'remove' command is used to remove an element from array.
""";
    private final String insertHelp = """
        
        insert <value> <position>   # Insert at defined position
        insert <value>              # Insert at last position
        
        INFO:
        'insert' command is used to insert values into currently selected array.
""";
    private final String checkoutHelp = """
       
       checkout <array-name>
       
       INFO :
       'checkout' command is used to switch between different arrays.
       Normally command pointer will be like ' >> ' when no array is selected and
       command pointer will be like 'arrayName (type) >> ' when array is selected.
""";
    private final String deleteHelp = """
       
       delete <array-name>
       
       INFO :
       Array name followed by 'delete' command will be removed from array slot remains with one empty slot.
""";
    private final String createHelp = """
       
       create <array-name> <type>
       
       Examples: 
       create <array-name> #default type is taken as int
       create <array-name> char 
       create <array-name> int 
       create <array-name> long
       create <array-name> float
       create <array-name> double
       create <array-name> string
       
       INFO :
       The arrays are created using this command, if type is not provided it will be taken as int array.
       There are only 10 array slots provided, Which means you can only create and maintain 10 arrays.
""";
    private final String pushHelp = """
       
       push <element>

       INFO :
       It inserts the given element at the end of the list.
""";
    private final String popHelp = """
       
       pop

       INFO :
       It removes the last element from the list and prints the element.
""";
    private final String enqueHelp = """
       
       enque <element>

       INFO :
       It inserts the given element in the beginning of the list.
""";
    private final String dequeHelp = """
       
       deque

       INFO :
       It removes the last element from the list and prints the element.
""";
    private final String lengthHelp = """
       
       length

       INFO :
       It shows the number of elements in the array.
""";


    public CommandEngine(AbstractArray arrayStack[], String arrayNames[]){
        this.arrayStack = arrayStack;
        this.arrayNames = arrayNames;
        this.status = "";
    }

    public void execute(String[] commandLets)  {
        SW1 :switch (commandLets[0]){
            case "help":
            {
                if (commandLets.length > 1){
                    switch (commandLets[1]){
                        case "exit":
                            System.out.println("\n\t\t===== HELP(exit) =====");
                            System.out.println("\t\tExits the application");
                            System.out.println("\n\t\t======================");
                            break;
                        case "create":
                            System.out.println("\n\t\t===== HELP(create) =====");
                            System.out.println(createHelp);
                            System.out.println("\n\t\t======================");
                            break;
                        case "delete":
                            System.out.println("\n\t\t===== HELP(delete) =====");
                            System.out.println(deleteHelp);
                            System.out.println("\n\t\t======================");
                            break;
                        case "checkout":
                            System.out.println("\n\t\t===== HELP(checkout) =====");
                            System.out.println(checkoutHelp);
                            System.out.println("\n\t\t======================");
                            break;

                        case "insert":
                            System.out.println("\n\t\t===== HELP(insert) =====");
                            System.out.println(insertHelp);
                            System.out.println("\n\t\t======================");
                            break;
                        case "remove":
                            System.out.println("\n\t\t===== HELP(remove) =====");
                            System.out.println(removeHelp);
                            System.out.println("\n\t\t======================");
                            break;
                        case "sort":
                            System.out.println("\n\t\t===== HELP(sort) =====");
                            System.out.println(sortHelp);
                            System.out.println("\n\t\t======================");
                            break;
                        case "find":
                            System.out.println("\n\t\t===== HELP(find) =====");
                            System.out.println(findHelp);
                            System.out.println("\n\t\t======================");
                            break;
                        case "show":
                            System.out.println("\n\t\t===== HELP(show) =====");
                            System.out.println(showHelp);
                            System.out.println("\n\t\t======================");
                            break;
                        case "push":
                            System.out.println("\n\t\t===== HELP(push) =====");
                            System.out.println(pushHelp);
                            System.out.println("\n\t\t======================");
                            break;
                        case "pop":
                            System.out.println("\n\t\t===== HELP(pop) =====");
                            System.out.println(popHelp);
                            System.out.println("\n\t\t======================");
                            break;
                        case "enque":
                            System.out.println("\n\t\t===== HELP(enque) =====");
                            System.out.println(enqueHelp);
                            System.out.println("\n\t\t======================");
                            break;
                        case "deque":
                            System.out.println("\n\t\t===== HELP(deque) =====");
                            System.out.println(dequeHelp);
                            System.out.println("\n\t\t======================");
                            break;
                        case "length":
                            System.out.println("\n\t\t===== HELP(length) =====");
                            System.out.println(lengthHelp);
                            System.out.println("\n\t\t======================");
                            break;
                    }
                }else System.out.println(help);
                break;
            }
            case "create":
            {
                if (top == arrayNames.length-1) {
                    System.out.println("Cannot maintain more than 10 arrays, Array slot full");
                    break ;
                }
                if(commandLets.length > 1){
                    String arrayName = commandLets[1];

                    if (commandLets.length > 2){
                        String type = commandLets[2];
                        switch (type){
                            case "char":
                                arrayStack[++top] = new AbstractArray<Character>("char");
                                break;
                            case "string":
                                arrayStack[++top] = new AbstractArray<String>("string");
                                break;
                            case "int":
                                arrayStack[++top] = new AbstractArray<Integer>("int");
                                break;
                            case "long":
                                arrayStack[++top] = new AbstractArray<Long>("long");
                                break;
                            case "double":
                                arrayStack[++top] = new AbstractArray<Double>("double");
                                break;
                            case "float":
                                arrayStack[++top] = new AbstractArray<Float>("float");
                                break;
                            default:
                                System.out.println("ERROR : invalid type | Type should be char, string, int, long, double, float");
                                break SW1;
                        }
                    }else {
                        arrayStack[++top] = new AbstractArray<Integer>("int");
                    }
                    arrayNames[top] = arrayName;
                    selected = top;
                }else {
                    System.out.println("ERROR: invalid syntax | \"create command should have array name and type(optional) \nSamples : \ncreate arr1 char \ncreate arr2 int \ncreate arr3 String \"");
                }
                break;
            }
            case "delete":
            {
                if(top < 0){
                    System.out.println("Array slot empty");
                    break;
                }
                if (commandLets.length > 1){
                    String arrayName = commandLets[1];
                    boolean notFound = true;
                    for (int i=0; i<top; i++){
                        if (arrayNames[i].equals(arrayName)){
                            arrayStack[i] = null;
                            arrayNames[i] = null;
                            if (selected == i) selected = -1;
                            for (int j = i; j<top; j++){
                                arrayStack[j] = arrayStack[j+1];
                                arrayNames[j] = arrayNames[j+1];
                            }
                            arrayNames[top] = null;
                            arrayStack[top] = null;
                            if (selected == top) selected -= 1;
                            --top;
                            notFound = false;
                        }
                    }
                    if (notFound) System.out.println("ERROR: array name '"+arrayName+"' not found");
                    break;

                }else System.out.println("ERROR : 'delete' command should have array name");
                break;
            }
            case "checkout":
            {
                if (commandLets.length>1){
                    String arrayName = commandLets[1];
                    boolean notFound = true;
                    for (int i=0; i<=top; i++){
                        if (arrayNames[i].equals(arrayName)){
                            selected = i;
                            notFound = false;
                        }
                    }
                    if (notFound) {
                        System.out.print("ERROR: array name '" + arrayName + "' not found | Available names [ ");
                        int i = -1;
                        while (arrayNames[++i] != null) System.out.print(arrayNames[i]+" ");
                        System.out.print("]\n");
                    }
                    break;
                }else {
                    if (top>-1){
                        System.out.print("Please enter array name after checkout command | Available names [ ");
                        int i = -1;
                        while (arrayNames[++i] != null) System.out.print(arrayNames[i]+" ");
                        System.out.print("]\n");
                    }else {
                        System.out.println("Please enter array name after checkout command | currently no arrays in stack | create new array using 'create' command use 'help create' to learn");
                    }
                }
                break;
            }
            case "show":
            {
                if (selected < 0) {
                    System.out.println("please use checkout command to select an array");
                    break ;
                }
                if(commandLets.length > 1){
                    String arrayName = commandLets[1];
                    if (arrayName.equals("*")) {
                        for (int i = 0; i <= top; i++) {
                            System.out.print(arrayNames[i]);
                            arrayStack[i].display();
                        }
                        break;
                    }else {
                        boolean notFound = true;
                        for (int i=0; i<=top; i++){
                            if (arrayNames[i].equals(arrayName)){
                                System.out.print(arrayNames[i]);
                                arrayStack[i].display();
                                notFound = false;
                            }
                        }
                        if (notFound) System.out.println("ERROR: array name '"+arrayName+"' not found");
                        break;
                    }
                }else {
                    arrayStack[selected].display();
                }

                break;
            }
            case "length":
            {
                if (selected < 0) {
                    System.out.println("please use checkout command to select an array");
                    break ;
                }
                System.out.println("Length of "+arrayNames[selected]+" is "+arrayStack[selected].length());
                break;
            }
            case "insert":
            {
                if (selected < 0) {
                    System.out.println("please use checkout command to select an array");
                    break ;
                }
                if(commandLets.length > 1){
                    String type = arrayStack[selected].getType();
                    commandLets[1] = commandLets[1].trim();
                    int pos = 0;

                    if (commandLets.length > 2){
                        try{
                            pos = Integer.parseInt(commandLets[2]);
                            if (pos > arrayStack[selected].length()) pos = 0;
                        }catch (NumberFormatException e){
                            System.out.println("Position argument must be an integer");
                        }
                    }
                    try{
                        switch (type){
                            case "char" :
                                arrayStack[selected].insert(pos, commandLets[1].charAt(0));
                                break;
                            case "int" :
                                arrayStack[selected].insert(pos, Integer.parseInt(commandLets[1]));
                                break;
                            case "long":
                                arrayStack[selected].insert(pos, Long.parseLong(commandLets[1]));
                                break;
                            case "float":
                                arrayStack[selected].insert(pos, Float.parseFloat(commandLets[1]));
                                break;
                            case "double" :
                                arrayStack[selected].insert(pos, Double.parseDouble(commandLets[1]));
                                break;
                            case "string":
                                arrayStack[selected].insert(pos, commandLets[1]);
                                break;
                        }

                    }catch (NumberFormatException e){
                        System.out.println("TYPE ERROR : Please use valid type of elements");
                    }
                }else{
                    System.out.println("ERROR : No elements to insert");
                }
                break;
            }
            case "remove":
            {
                if (selected < 0) {
                    System.out.println("please use checkout command to select an array");
                    break ;
                }
                if(commandLets.length > 1){
                    String type = arrayStack[selected].getType();
                    commandLets[1] = commandLets[1].trim();
                    int pos = 0;

                    if(commandLets[1].equals("-p")){
                        if (commandLets.length > 2){
                            try{
                                pos = Integer.parseInt(commandLets[2]);
                            }catch (NumberFormatException e){
                                System.out.println("ERROR : position must be an integer");
                            }
                        }else {
                            System.out.println("ERROR : please enter position argument");
                        }
                    }else {
                        try{
                            switch (type){
                                case "char" :
                                    pos = arrayStack[selected].search(1, -1, commandLets[1].charAt(0));
                                    break;
                                case "int" :
                                    pos = arrayStack[selected].search(1, -1, Integer.parseInt(commandLets[1]));
                                    break;
                                case "long":
                                    pos = arrayStack[selected].search(1, -1, Long.parseLong(commandLets[1]));
                                    break;
                                case "float":
                                    pos = arrayStack[selected].search(1, -1, Float.parseFloat(commandLets[1]));
                                    break;
                                case "double" :
                                    pos = arrayStack[selected].search(1, -1, Double.parseDouble(commandLets[1]));
                                    break;
                                case "string":
                                    pos = arrayStack[selected].search(1, -1, commandLets[1]);
                                    break;
                            }
                        }catch (NumberFormatException e){
                            System.out.println("TYPE ERROR : Please use valid type of elements");
                        }
                    }
                    if (pos == 0) {
                        System.out.println("ERROR : Element not found");
                        break ;
                    }
                    try{
                        switch (type){
                            case "char" :
                                arrayStack[selected].remove(pos);
                                break;
                            case "int" :
                                arrayStack[selected].remove(pos);
                                break;
                            case "long":
                                arrayStack[selected].remove(pos);
                                break;
                            case "float":
                                arrayStack[selected].remove(pos);
                                break;
                            case "double" :
                                arrayStack[selected].remove(pos);
                                break;
                            case "string":
                                arrayStack[selected].remove(pos);
                                break;
                        }
                    }catch (NumberFormatException e){
                        System.out.println("TYPE ERROR : Please enter valid type of element");
                    }
                }else{
                    System.out.println("ERROR : No elements to remove");
                }
                break;
            }
            case "find":
            {
                if (selected < 0) {
                    System.out.println("please use checkout command to select an array");
                    break ;
                }
                if(commandLets.length > 1){
                    String type = arrayStack[selected].getType();
                    commandLets[1] = commandLets[1].trim();
                    int start = 1;
                    int end = arrayStack[selected].length();
                    try{
                        if (commandLets.length > 2) {
                            start = Integer.parseInt(commandLets[2]);
                        }
                        if (commandLets.length > 3) {
                            end = Integer.parseInt(commandLets[3]);
                        }
                    }catch(NumberFormatException e) {
                        System.out.println("ERROR : position arguments must be integer");
                    }
                    try{
                        int pos = 0;
                        switch (type){
                            case "char" :
                                pos = arrayStack[selected].search(start, end, commandLets[1].charAt(0));
                                break;
                            case "int" :
                                pos = arrayStack[selected].search(start, end, Integer.parseInt(commandLets[1]));
                                break;
                            case "long":
                                pos = arrayStack[selected].search(start, end, Long.parseLong(commandLets[1]));
                                break;
                            case "float":
                                pos = arrayStack[selected].search(start, end, Float.parseFloat(commandLets[1]));
                                break;
                            case "double" :
                                pos = arrayStack[selected].search(start, end, Double.parseDouble(commandLets[1]));
                                break;
                            case "string":
                                pos = arrayStack[selected].search(start, end, commandLets[1]);
                                break;
                        }
                        if(pos == 0){
                            System.out.println("Element not found in the array");
                            break;
                        }
                        System.out.println("Element found at position "+pos);
                    }catch (NumberFormatException e){
                        System.out.println("TYPE ERROR : Please use valid type of elements");
                    }
                }else System.out.println("ERROR : Should provide search element after 'find' command");
                break;
            }
            case "sort":
            {
                if (selected < 0) {
                    System.out.println("please use checkout command to select an array");
                    break ;
                }
                if (commandLets.length>1){
                    int direction = 1;
                    int start = 1;
                    int end = arrayStack[selected].length()+1;
                    if (commandLets.length == 2){
                        try {
                            direction = Integer.parseInt(commandLets[1]);
                        }catch (NumberFormatException e) {
                            System.out.println("ERROR : sort direction should be -1 or 1 ");
                        }
                    } else if (commandLets.length == 3) {
                        try {
                            int startInp = Integer.parseInt(commandLets[1]);
                            if(startInp < 0){
                                start = arrayStack[selected].length()+startInp+1;
                                System.out.println("?"+startInp+"1=>"+start);
                            }
                            else start = startInp;
                            direction = Integer.parseInt(commandLets[2]);
                        }catch (NumberFormatException e) {
                            System.out.println("ERROR : Enter valid args ");
                        }
                    } else if (commandLets.length > 3) {
                        try {
                            int startInp = Integer.parseInt(commandLets[1]);
                            int endInp = Integer.parseInt(commandLets[2])+1;
                            if(startInp < 0){
                                start = arrayStack[selected].length()+startInp+1;
                                System.out.println("?"+startInp+"->"+start);
                            }else start = startInp;
                            if(endInp < 0){
                                end = arrayStack[selected].length()+endInp+1;;
                                System.out.println("?"+endInp+"->"+end);
                            }else end = endInp;
                            direction = Integer.parseInt(commandLets[3]);
                        }catch (NumberFormatException e) {
                            System.out.println("ERROR : Enter valid args ");
                        }
                    }

                    arrayStack[selected].sort(start, end, direction);
                    break;
                }else {
                    arrayStack[selected].sort(1,arrayStack[selected].length()+1,1);
                }
                break;
            }
            case "pop":
                if (selected < 0) {
                    System.out.println("please use checkout command to select an array");
                    break ;
                }
                String poped = arrayStack[selected].remove(-1);
                System.out.println(poped);
                break ;
            case "push":
                if (selected < 0) {
                    System.out.println("please use checkout command to select an array");
                    break ;
                }
                if(commandLets.length > 1){
                    String type = arrayStack[selected].getType();
                    commandLets[1] = commandLets[1].trim();
                    int pos = 0;

                    try{
                        switch (type){
                            case "char" :
                                arrayStack[selected].insert(pos, commandLets[1].charAt(0));
                                break;
                            case "int" :
                                arrayStack[selected].insert(pos, Integer.parseInt(commandLets[1]));
                                break;
                            case "long":
                                arrayStack[selected].insert(pos, Long.parseLong(commandLets[1]));
                                break;
                            case "float":
                                arrayStack[selected].insert(pos, Float.parseFloat(commandLets[1]));
                                break;
                            case "double" :
                                arrayStack[selected].insert(pos, Double.parseDouble(commandLets[1]));
                                break;
                            case "string":
                                arrayStack[selected].insert(pos, commandLets[1]);
                                break;
                        }

                    }catch (NumberFormatException e){
                        System.out.println("TYPE ERROR : Please use valid type of elements");
                    }
                }else{
                    System.out.println("ERROR : No elements to insert");
                }
                break ;
            case "enque":
                if (selected < 0) {
                    System.out.println("please use checkout command to select an array");
                    break ;
                }
                if(commandLets.length > 1){
                    String type = arrayStack[selected].getType();
                    commandLets[1] = commandLets[1].trim();
                    int pos = 1;

                    try{
                        switch (type){
                            case "char" :
                                arrayStack[selected].insert(pos, commandLets[1].charAt(0));
                                break;
                            case "int" :
                                arrayStack[selected].insert(pos, Integer.parseInt(commandLets[1]));
                                break;
                            case "long":
                                arrayStack[selected].insert(pos, Long.parseLong(commandLets[1]));
                                break;
                            case "float":
                                arrayStack[selected].insert(pos, Float.parseFloat(commandLets[1]));
                                break;
                            case "double" :
                                arrayStack[selected].insert(pos, Double.parseDouble(commandLets[1]));
                                break;
                            case "string":
                                arrayStack[selected].insert(pos, commandLets[1]);
                                break;
                        }

                    }catch (NumberFormatException e){
                        System.out.println("TYPE ERROR : Please use valid type of elements");
                    }
                }else{
                    System.out.println("ERROR : No elements to insert");
                }
                break ;
            case "deque":
                if (selected < 0) {
                    System.out.println("please use checkout command to select an array");
                    break ;
                }
                arrayStack[selected].remove(-1);
                break ;

            default :
                System.out.println("ERROR : command "+commandLets[0]+" is not a valid command");
                break;
        }
        if (selected>-1) status = arrayNames[selected]+" ("+arrayStack[selected].getType()+") ";
        System.out.print(status+" >> ");
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}


class AbstractArray<T> {
    private T[] array;
    private final int DEFAULT_CAP = 3;
    private int top = -1;
    private int arrayCapacity = DEFAULT_CAP;
    private void extendArray(){
        T[] temp = (T[]) new Object[arrayCapacity*2];
        for (int i = 0; i<array.length; i++){
            temp[i] = array[i];
        }
        array = temp;
        arrayCapacity = arrayCapacity*2;
    }
    private String type;

    public int size(){
        return array.length;
    }

    public int length(){
        return this.top+1;
    }

    public AbstractArray(){ //Default Constructor
        array = (T[]) new Object[arrayCapacity];
    }
    public AbstractArray(String type){ //Default Constructor
        array = (T[]) new Object[arrayCapacity];
        this.type = type;
    }
    public AbstractArray(int capacity){ //Parametrized Constructor
        arrayCapacity = capacity;
        array = (T[]) new Object[arrayCapacity];
    }

    public int insert(int position, T element){ // Returns inserted index as return value

        if (position < 1){
            position = top+1+position; //Insert reverse;
        }else {
            position--; // index conversion;
        }

        if(position >= arrayCapacity) extendArray();
        if(top < position){
            array[position] = element;
            top = position;
        }else {
            if (arrayCapacity == top+1) extendArray();
            for (int i = position; i < top+1; i++){
                T temp = array[i];
                array[i] = element ;
                element = temp;
            }
            array[top+1] = element;
            top++;
        }
        return 0;
    }

    public String remove(int position){ // Returns inserted index as return value
        String temp = "Array Empty";
        if (position == 0){
            System.out.println("ERROR : Position argument cannot be zero for remove | It should be positive or negative numbers");
        }
        if(top < 0){
            return temp;
        }
        if (position <= top+1){
            if (position < 1){
                position = top+1+position; //Insert reverse;
                if(position < 0){
                    return temp;
                }
            }else {
                position--; // index conversion;
            }

            //remove element at position
            temp = array[position].toString();
            array[position] = null;
            while (position < top){
                position++;
                array[position-1] = array[position];
            }
            array[top] = null;
            top--;

        }else {
            System.out.println("ERROR : Position index out of range");
            position = -1;
        }

        return temp;
    }

    public int search(int startPosition,int endPosition, T element){
        if(this.top < 0){
            return 0; // means array is empty
        }
        if (startPosition < 1){
            System.out.println("ERROR : Position argument should be more than 1");
        }
        if (endPosition <= top+1){
            if (endPosition < 1){
                endPosition = top+1+endPosition; // inversion
            }else {
                endPosition--;
            }
            //search
            int i = --startPosition ; //search from
            for (; i <= endPosition; i++){
                if (array[i].equals(element)) return i+1;
            }

        }else {
            System.out.println("ERROR : Position index out of range");
            return -1;
        }

        return 0;
    }

    public void sort(int startPosition, int endPosition, int direction){
        if (!(direction == 1 || direction == -1)) System.out.println("ERROR : Direction must be 1 for ascending and -1 for decending");
        else {
            T arr[] = array;
            int i = startPosition-1, j = 0;
            for (;i<endPosition-1;i++){
                for (j=i+1;j<endPosition-1;j++){
                    if (direction == -1){
                        if (!lesserThan(arr[i], arr[j])){
                            T temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }else {
                        if (lesserThan(arr[i], arr[j])){
                            T temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }
                }
            }
        }
    }

    private boolean lesserThan(T m, T n){
        boolean flag = false;

        if (m instanceof String){
            String a = (String) m;
            String b = (String) n;

            int len = a.length();
            if(a.length() > b.length()){
                len = b.length();
            }

            for (int i=0; i<len; i++){
                if(a.charAt(i) > b.charAt(i)){
                    return false;
                } else if (a.charAt(i) < b.charAt(i)) {
                    return true;
                }else {
                    continue;
                }
            }

            return true;
        }else if(m instanceof Double){
            return ((Double) m > (Double) n);
        }else if(m instanceof Float){
            return ((Float) m > (Float) n);
        }else if(m instanceof Integer){
            return ((Integer) m > (Integer) n);
        }else if(m instanceof Long){
            return ((Long) m > (Long) n);
        } else if (m instanceof Character) {
            return ( (char) m > (char)n);
        }
        return false;
    }

    public void display(){ // Returns inserted index as return value
        String result = "";
        if (top<0) result = "Empty Array";
        else result = Arrays.toString(Arrays.stream(array)
                .filter(Objects::nonNull)
                .toArray());
        System.out.println(result+"("+this.length()+"/"+this.size()+")");
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString(){
        if (top<0) return "Empty Array";
        return Arrays.toString(array);
    }
}
