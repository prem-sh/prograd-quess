public class Q2_CountDivisors {

        public long numberOfDivisors(int n) {
            int count = 0;
            for(int i = 1; i<=n; i++) count = (n%i==0)? count+1:count;
            return count;
        }
}
