package Graph;

import java.util.*;
import java.io.*;
import java.math.*;

public class tarjanAlgo {
    static StringBuilder sb;
    static dsu dsu;
    static long fact[];
    static int mod = (int) (1e9 + 7);

    static void solve() {
        int n = 11;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(3);
        graph.get(1).add(2);
        graph.get(1).add(4);
        graph.get(2).add(0);
        graph.get(2).add(6);
        graph.get(3).add(2);
        graph.get(4).add(5);
        graph.get(4).add(6);
        graph.get(5).add(6);
        graph.get(5).add(7);
        graph.get(5).add(8);
        graph.get(5).add(9);
        graph.get(6).add(4);
        graph.get(7).add(9);
        graph.get(8).add(9);
        graph.get(9).add(8);
        // System.out.println(graph);

        tarjan(graph, n);
    }

    static int time;

    private static void tarjan(ArrayList<ArrayList<Integer>> graph, int n) {
        int[] low = new int[n];
        int[] disc = new int[n];
        boolean[] presentInStack = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            low[i]=disc[i]=-1;
        }
        time = 0;

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, graph, disc, low, presentInStack, st);
            }
        }
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> graph, int[] disc, int[] low, boolean[] presentInStack,Stack<Integer> st) {

        disc[i] = low[i] = time++;
        st.push(i);
        presentInStack[i] = true;
        
        for (int nbr : graph.get(i)) {
            if (disc[nbr] == -1) {
                dfs(nbr, graph, disc, low, presentInStack, st);
                low[i] = Math.min(low[i], low[nbr]);
            }

            // if this is the back edge
            else if (presentInStack[nbr]) {
                low[i] = Math.min(low[i], disc[nbr]);
            }
        }

        // if this is the head of the SCC
        if (low[i] == disc[i]) {
            System.out.print("SCC is :- ");

            while (st.peek() != i) {
                int temp = st.pop();
                System.out.print(temp + " ");
                presentInStack[temp] = false;
            }
            int temp = st.pop();
            System.out.print(temp + " ");
            presentInStack[temp] = false;
        }
    }

    public static void main(String[] args) {
        sb = new StringBuilder();
        int test = 1;
        while (test-- > 0) {
            solve();
        }
        System.out.println(sb);
    }

    /*
     * fact=new long[(int)1e6+10]; fact[0]=fact[1]=1; for(int i=2;i<fact.length;i++)
     * { fact[i]=((long)(i%mod)1L(long)(fact[i-1]%mod))%mod; }
     */
    // **************NCR%P******************
    static long ncr(int n, int r) {
        if (r > n)
            return (long) 0;

        long res = fact[n] % mod;
        // System.out.println(res);
        res = ((long) (res % mod) * (long) (p(fact[r], mod - 2) % mod)) % mod;
        res = ((long) (res % mod) * (long) (p(fact[n - r], mod - 2) % mod)) % mod;
        // System.out.println(res);
        return res;

    }

    static long p(long x, long y)// POWER FXN //
    {
        if (y == 0)
            return 1;

        long res = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % mod;
                y--;
            }

            x = (x * x) % mod;
            y = y / 2;

        }
        return res;
    }

    // **************END******************

    // *************Disjoint set
    // union*********//
    static class dsu {
        int parent[];

        dsu(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = -1;
        }

        int find(int a) {
            if (parent[a] < 0)
                return a;
            else {
                int x = find(parent[a]);
                parent[a] = x;
                return x;
            }
        }

        void merge(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b)
                return;
            parent[b] = a;
        }
    }

    // **************PRIME FACTORIZE **********************************//
    static TreeMap<Integer, Integer> prime(long n) {
        TreeMap<Integer, Integer> h = new TreeMap<>();
        long num = n;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (n % i == 0) {
                int nt = 0;
                while (n % i == 0) {
                    n = n / i;
                    nt++;
                }
                h.put(i, nt);
            }
        }
        if (n != 1)
            h.put((int) n, 1);
        return h;

    }

    // ****CLASS PAIR ************************************************

    // ****CLASS PAIR **************************************************

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int Int() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String String() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return String();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);

    public static long[] sort(long[] a2) {
        int n = a2.length;
        ArrayList<Long> l = new ArrayList<>();
        for (long i : a2)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < l.size(); i++)
            a2[i] = l.get(i);
        return a2;
    }

    public static long pow(long x, long y) {
        long res = 1;
        while (y > 0) {
            if (y % 2 != 0) {
                res = (res * x);// % modulus;
                y--;

            }
            x = (x * x);// % modulus;
            y = y / 2;
        }
        return res;
    }

    // GCD___+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static long gcd(long x, long y) {
        if (x == 0)
            return y;
        else
            return gcd(y % x, x);
    }
    // ******LOWEST COMMON MULTIPLE
    // *********************************************

    public static long lcm(long x, long y) {
        return (x * (y / gcd(x, y)));
    }

    // INPUT PATTERN********************************************************
    public static int i() {
        return in.Int();
    }

    public static long l() {
        String s = in.String();
        return Long.parseLong(s);
    }

    public static String s() {
        return in.String();
    }

    public static int[] readArray(int n) {
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i();
        }
        return A;
    }

    public static long[] readArray(long n) {
        long A[] = new long[(int) n];
        for (int i = 0; i < n; i++) {
            A[i] = l();
        }
        return A;
    }
}
