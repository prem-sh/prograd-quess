public class Q1_SumOfNumbers {
    int get_sum(int a, int b)
    {
        int sum = 0;
        if(a == b){
            return a;
        }
        else {
            if(a>b){
                a = a+b;
                b = a-b;
                a = a-b;
            }
            for(int i=a; i<=b; i++) sum+=i;
            return sum;
        }
    }
}
