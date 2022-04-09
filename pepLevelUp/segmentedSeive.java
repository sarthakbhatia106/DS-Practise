import java.util.*;

public class segmentedSeive {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int m = scn.nextInt();
            int n = scn.nextInt();

            StringBuilder sb=new StringBuilder();
            ArrayList<Integer> primes = primeSeive((int) Math.pow(n, 0.5));

            boolean[] ans = new boolean[(n - m) + 1];

            for (int i : primes) {
                int start = (int) Math.ceil((1.0 * m) / i);
                if(start==1){
                    start++;
                }
                int idx=(start*i)-m;
                for (int j = idx; j < ans.length; j += i) {
                    ans[j] = true;
                }
            }

            for (int i = 0; i < ans.length; i++) {
                if (ans[i] == false && (i+m)!=1) {
                    sb.append((i + m)+"\n");
                }
            }
            // sb.append("\n");
            System.out.println(sb.toString());
        }
        scn.close();
    }

    public static ArrayList<Integer> primeSeive(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] seive = new boolean[n + 1];

        for (int i = 2; i * i <= seive.length; i++) {
            if (seive[i] == false) {
                for (int j = i * i; j < seive.length; j += i) {
                    seive[j] = true;
                }
            }
        }
        for (int i = 2; i < seive.length; i++) {
            if (seive[i] == false) {
                primes.add(i);
            }
        }
        return primes;
    }
}