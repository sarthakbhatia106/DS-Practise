import java.io.*;
public class secretCode{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String str=br.readLine();

            int []z=new int[str.length()];
            int i=0;
            int l=0,r=0;
            int ans=Integer.MAX_VALUE;

            while(i<n){
                if(i<=r){
                    z[i]=Math.min(z[i-l], r-i+1);
                }
                while(i+z[i]<str.length() && str.charAt(z[i])==str.charAt(i+z[i])){
                    z[i]++;
                }

                if(i+z[i]-1>r){
                    l=i;
                    r=i+z[i]-1;
                }
                if(z[i]!=0){
                    ans=Math.min(ans,z[i]);
                }
                i++;
            }
            System.out.println(str.substring(0, ans));
        }
    }
}