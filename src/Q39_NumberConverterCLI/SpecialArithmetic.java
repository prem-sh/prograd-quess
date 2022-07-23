package Q39_NumberConverterCLI;

public class SpecialArithmetic{
    public static String[] division(String number, int divisor){
        String[] result = new String[2]; // will store quotient and reminder

        StringBuilder buffer = new StringBuilder();
        char[] dividend = number.toCharArray();
        int carry = 0;
        for (int i = 0; i < dividend.length; i++) {
            int x = carry * 10 + Character.getNumericValue(dividend[i]);
            buffer.append(x / divisor);
            carry = x % divisor;
        }

        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) != '0') {
                result[0] = buffer.substring(i);
                result[1] = String.valueOf(carry);
                return result;
            }
        }
        result[0] = "0";
        result[1] = String.valueOf(carry);
        return result;
    }
    public static String modulo(String dividend, int divisor){
        String reminder = division(dividend, divisor)[1];
        return reminder;
    }
    public static String addition(String str1, String str2){
        if (str1.length() > str2.length()){
            String t = str1;
            str1 = str2;
            str2 = t;
        }
        StringBuilder str = new StringBuilder();
        int n1 = str1.length(), n2 = str2.length();

        str1=new StringBuilder(str1).reverse().toString();
        str2=new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++)
        {
            int sum = ((int)(str1.charAt(i) - '0') + (int)(str2.charAt(i) - '0') + carry);
            str.append((char) (sum % 10 + '0'));

            // Calculate carry for next step
            carry = sum / 10;
        }

        for (int i = n1; i < n2; i++)
        {
            int sum = ((int)(str2.charAt(i) - '0') + carry);
            str.append((char) (sum % 10 + '0'));
            carry = sum / 10;
        }

        if (carry > 0) str.append((char) (carry + '0'));
        str = new StringBuilder(str.toString()).reverse();
        return str.toString();
    }
    public static String multiply(String num1, String num2){
            int len1 = num1.length();
            int len2 = num2.length();
            if (len1 == 0 || len2 == 0)
                return "0";

            int result[] = new int[len1 + len2];

            int i_n1 = 0;
            int i_n2 = 0;

            for (int i = len1 - 1; i >= 0; i--)
            {
                int carry = 0;
                int n1 = num1.charAt(i) - '0';
                i_n2 = 0;

                for (int j = len2 - 1; j >= 0; j--)
                {
                    int n2 = num2.charAt(j) - '0';
                    int sum = n1 * n2 + result[i_n1 + i_n2] + carry;
                    carry = sum / 10;
                    result[i_n1 + i_n2] = sum % 10;
                    i_n2++;
                }
                if (carry > 0) result[i_n1 + i_n2] += carry;
                i_n1++;
            }

            int i = result.length - 1;
            while (i >= 0 && result[i] == 0) i--;

            if (i == -1) return "0";
            String s = "";
            while (i >= 0) s += (result[i--]);
            return s;
    }
    public static String power(String a, int n){
        StringBuilder result = new StringBuilder(a);
        if(n==0) return "1";
        for (int i=2; i<=n; i++){
           result.replace(0,result.length(), multiply(result.toString(),a));
        }
        return result.toString();
    }
}
