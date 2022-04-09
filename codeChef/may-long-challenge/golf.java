import java.io.*;

public class golf {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String []str=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int x=Integer.parseInt(str[1]);
            int k=Integer.parseInt(str[2]);

            if(x%k==0){
                System.out.println("YES");
            }else{
                int mod=(n+1)%k;
                System.out.println((x%k)==mod? "YES":"NO");
            }
        }
    }
}
