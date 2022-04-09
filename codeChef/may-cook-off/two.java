import java.io.*;

public class two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] str = br.readLine().split(" ");

            int g = Integer.parseInt(str[0]);
            int p = Integer.parseInt(str[1]);

            int[] arr = new int[10];

            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(str[i + 2]);
            }

            int sum = 0;
            for (int i = g; i < 10; i++) {
                sum += arr[i];
            }

            if (sum % p == 0) {
                int days = sum / p;
                if (arr[g - 1] <= p) {
                    System.out.println((days + 1) + " " + (days + 1));
                } else {
                    System.out.println((days + 1) + " " + (days + 2 + arr[g - 1] / p));
                }
            } else {
                int vac = p - (sum % p);
                int days = sum / p + 1;
                if (arr[g - 1] <= vac) {
                    System.out.println((days) + " " + (days));
                } else {
                    arr[g - 1] -= vac;
                    int min = days;
                    int max = -1;
                    if (arr[g - 1] <= p) {
                        max=(days + 1);
                    } else {
                        max=(days + 2 + arr[g - 1] / p);
                    }
                    System.out.println(min + " " + max);
                }
            }
        }
    }
}
