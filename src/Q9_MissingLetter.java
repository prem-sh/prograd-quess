public class Q9_MissingLetter {
    public static char findMissingLetter(char[] array)
    {
        char out = ' ';
        for(int i = 0; i < array.length - 1; i++) if(array[i+1]-array[i] > 1)
        {
            out = ++array[i];
        }
        return out;
    }
}
