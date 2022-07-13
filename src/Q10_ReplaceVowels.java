public class Q10_ReplaceVowels {
    public static String disemvowel(String str) {
        String vow = "aeiouAEIOU";
        String out = "";
        for(char i : str.toCharArray()) if(!vow.contains(String.valueOf(i))) out+=String.valueOf(i);

        return out;
    }
}
