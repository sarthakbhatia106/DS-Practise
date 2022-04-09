import java.io.*;

public class NastiaandNearlyGoodNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            if(b<=1){
                System.out.println("NO");
            }else if(b==2){
                System.out.println("YES");
                System.out.println(a+" "+(long)((2*b-1)*a)+" "+(long)2*a*b);
            }else{
                System.out.println("YES");
                System.out.println(a+" "+(long)((b-1)*a)+" "+(long)a*b);
            }

        }
    }
}
