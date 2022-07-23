package Q39_NumberConverterCLI.exceptions;

public class InvalidNumberFormatException extends Exception{
    private static final String RESET = "\u001B[0m";
    private static final String ERROR = "\033[1;91m";

    public InvalidNumberFormatException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return ERROR+super.getMessage()+RESET;
    }
}
