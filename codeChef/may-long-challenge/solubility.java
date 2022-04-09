import java.io.*;

public class solubility{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String []str=br.readLine().split(" ");
            int x=Integer.parseInt(str[0]);
            int a=Integer.parseInt(str[1]);
            int b=Integer.parseInt(str[2]);

            System.out.println((a+((100-x)*b))*10);
        }
    }
}