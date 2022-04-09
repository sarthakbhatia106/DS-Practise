import java.io.*;
import java.util.*;

public class two {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            String str = scn.next();

            boolean done = false;
            for (int i = 0; i < 26; i++) {
                char s1 = (char) (i + 'a');
                String s = s1 + "";
                if (search(str, s) == false) {
                    System.out.println(s);
                    done = true;
                    break;
                }
            }
            if (done == false) {
                for (int i = 0; i < 26; i++) {
                    boolean check = false;
                    for (int j = 0; j < 26; j++) {
                        char s1 = (char) (i + 'a');
                        char s2 = (char) (j + 'a');
                        String s = (s1 + "") + (s2 + "");
                        if (search(str, s) == false) {
                            System.out.println(s);
                            check = true;
                            done = true;
                            break;
                        }
                    }
                    if (check)
                        break;
                }
            }
            if (done == false) {
                for (int k = 0; k < 26; k++) {
                    boolean check = false;
                    for (int i = 0; i < 26; i++) {
                        for (int j = 0; j < 26; j++) {
                            char s1 = (char) (k + 'a');
                            char s2 = (char) (i + 'a');
                            char s3 = (char) (j + 'a');
                            String s = (s1 + "") + (s2 + "") + (s3 + "");
                            if (search(str, s) == false) {
                                System.out.println(s);
                                check = true;
                                done = true;
                                break;
                            }
                        }
                        if (check)
                            break;
                    }
                    if(check)break;
                }
            }
        }
    }

    public static boolean search(String text, String pattern) {

        String concat = pattern + "$" + text;
        int l = concat.length();
        int Z[] = new int[l];

        getZarr(concat, Z);

        for (int i = 0; i < l; ++i) {
            if (Z[i] == pattern.length()) {
                return true;
            }
        }
        return false;
    }

    private static void getZarr(String str, int[] Z) {
        int n = str.length();

        int L = 0, R = 0;

        for (int i = 1; i < n; ++i) {
            if (i > R) {

                L = R = i;
                while (R < n && str.charAt(R - L) == str.charAt(R))
                    R++;

                Z[i] = R - L;
                R--;
            } else {
                int k = i - L;
                if (Z[k] < R - i + 1)
                    Z[i] = Z[k];
                else {
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R))
                        R++;

                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }
}
