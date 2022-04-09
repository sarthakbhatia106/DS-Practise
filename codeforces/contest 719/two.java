import java.io.*;

public class two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            long n = Long.parseLong(str);
            long ans = 0;
            
            int len=str.length()-1;
            ans+=(len*9);
            char first=str.charAt(0);
            String a=first+"";
            ans+=first-'0';
            for(int i=0;i<len;i++){
                a+=first;
            }
            if(Long.parseLong(a)>n){
                ans--;
            }
            System.out.println(ans);
        }
    }
}
