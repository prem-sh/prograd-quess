public class Q8_ValidatePin {
    public static boolean validatePin(String pin) {
        for(char i : pin.toCharArray()) if(!(i >= '0' && i <= '9')) return false;
        if(!(pin.length() == 4 || pin.length() == 6)) return false;
        return true;
    }
}
