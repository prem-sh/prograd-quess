public class Q4_SumCubes {
        public static long sumCubes(long n)
        {
            long sum = 0;
            for(long i=1; i<=n; i++) sum+= (i*i*i);
            return sum;
        }
}
