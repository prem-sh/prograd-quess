package Q39_NumberConverterCLI;

import Q39_NumberConverterCLI.exceptions.*;

public class converterAPI{
    //Constants
    public static final String BIN = "Binary";
    public static final String OCT = "Octal";
    public static final String DEC = "Decimal";
    public static final String HEX = "Hexadecimal";

    public static String convert(String input, String output){
        //Validation
        try{
            validate(input);
        }catch (InvalidNumberFormatException e){
            return e.getMessage();
        }
        String result;
        switch (detectInput(input)){
            case BIN:
                switch (output){
                    case OCT:
                        result = toDecimal(input);
                        return "0o"+toOctal(result);
                    case HEX:
                        result = toDecimal(input);
                        return "0x"+toHexadecimal(result);
                    case DEC: return toDecimal(input);
                    default: return "Internal Error in ConverterAPI.convert() function";
                }
            case OCT:
                switch (output){
                    case BIN:
                        result = toDecimal(input);
                        return "0b"+toBinary(result);
                    case HEX:
                        result = toDecimal(input);
                        return "0x"+toHexadecimal(result);
                    case DEC: return toDecimal(input);
                    default: return "Internal Error in ConverterAPI.convert() function";
                }
            case HEX:
                switch (output){
                    case OCT:
                        result = toDecimal(input);
                        return "0o"+toOctal(result);
                    case BIN:
                        result = toDecimal(input);
                        return "0b"+toBinary(result);
                    case DEC: return toDecimal(input);
                    default: return "Internal Error in ConverterAPI.convert() function";
                }
            case DEC:
                switch (output){
                    case OCT: return "0o"+toOctal(input);
                    case HEX: return "0x"+toHexadecimal(input);
                    case BIN: return "0b"+toBinary(input);
                    default: return "Internal Error in ConverterAPI.convert() function";
                }
            default: return "";
        }
    }
    public static String toDecimal(String input){
        String result = "0";

        if(input.startsWith("0b")){
            input = input.substring(2);
            int n = 0;
            while(true){
                if(input.equals("0")){
                    break;
                } else {
                    String temp = SpecialArithmetic.modulo(input,10);
                    String temp2 = SpecialArithmetic.multiply(temp, SpecialArithmetic.power("2",n));
                    result = SpecialArithmetic.addition(result,temp2);
                    input = SpecialArithmetic.division(input,10)[0];
                    n++;
                }
            }

            return result;
        }
        else if (input.startsWith("0o")) {
            input = input.substring(2);
            int n = 0;
            while(true){
                if(input.equals("0")){
                    break;
                } else {
                    String temp = SpecialArithmetic.modulo(input,10);
                    String temp2 = SpecialArithmetic.multiply(temp, SpecialArithmetic.power("8",n));
                    result = SpecialArithmetic.addition(result,temp2);
                    input = SpecialArithmetic.division(input,10)[0];
                    n++;
                }
            }
            return result;
        }
        else if (input.startsWith("0x")) {
            input = input.substring(2);
            String digits = "0123456789ABCDEF";
            input = input.toUpperCase();

            for (int i = 0; i < input.length(); i++)
            {
                char c = input.charAt(i);
                int d = digits.indexOf(c);
                result = SpecialArithmetic.addition(SpecialArithmetic.multiply(result,"16"), String.valueOf(d));
            }
            return result;
        } else return input;
    }
    public static String toBinary(String decimal){
        StringBuilder binary = new StringBuilder();
        int index = 0;

        while(decimal != "0"){
            binary.insert(0,SpecialArithmetic.modulo(decimal,2));
            decimal = SpecialArithmetic.division(decimal,2)[0];
        }
        if(binary.length() == 0) return "0";
        return binary.toString();
    }
    public static String toOctal(String decimal){
        StringBuilder octal = new StringBuilder();
        int index = 0;

        while(decimal != "0"){
            octal.insert(0,SpecialArithmetic.modulo(decimal,8));
            decimal = SpecialArithmetic.division(decimal,8)[0];
        }
        if(octal.length() == 0) return "0";
        return octal.toString();
    }
    public static String toHexadecimal(String decimal){
        StringBuilder hexa = new StringBuilder();
        char hex[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal != "0"){
            hexa.insert(0,String.valueOf(hex[Integer.parseInt(SpecialArithmetic.modulo(decimal,16))]));
            decimal = SpecialArithmetic.division(decimal,16)[0];
        }
        if(hexa.length() == 0) return "0";
        return hexa.toString();
    }

    private static String detectInput(String input){  //returns DEC, BIN, OCT, HEX
        if(input.startsWith("0b")) return BIN;
        else if (input.startsWith("0o")) return OCT;
        else if (input.startsWith("0x")) return HEX;
        else return DEC;
    }
    private static boolean validate(String input) throws InvalidNumberFormatException {
        String charSet = "";
        if(input.startsWith("0b")) charSet = "01";
        else if (input.startsWith("0o")) charSet = "01234567";
        else if (input.startsWith("0x")) charSet = "0123456789ABCDEFabcdef";
        else charSet = "0123456789";
        input = input.substring(2);
        for (int i=0;i<input.length();i++){
            if(!charSet.contains(String.valueOf(input.charAt(i)))) throw new InvalidNumberFormatException("Invalid number format please check and try again");
        }
        return true;
    }
}

