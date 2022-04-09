import java.io.*;
public class twoTemp {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String []str=br.readLine().split(" ");

            int g=Integer.parseInt(str[0]);
            int p=Integer.parseInt(str[1]);

            int []arr=new int[10];

            for(int i=0;i<10;i++){
                arr[i]=Integer.parseInt(str[i+2]);
            }


            int vac=p;
            int days=0;

            for(int i=9;i>=g;i--){
                if(arr[i]<vac){
                    vac-=arr[i];
                }else if(arr[i]==vac){
                    days++;
                }else{
                    int temp=arr[i];
                    temp-=vac;
                    vac=p;
                    days++;
                    if(temp%vac==0){
                        days+=temp/vac;
                        vac=p;
                    }else{
                        days+=temp/vac;
                        days++;
                        vac=temp%vac;
                    }
                }
            }
            
            if(arr[g-1]<=vac){
                
                System.out.println(days+" "+days);
            }else{
                if((arr[g-1]-vac)%vac==0){
                    System.out.println(days+" "+(days+(arr[g-1]-vac)/p));
                }else{
                    System.out.println(days+" "+(days+(arr[g-1]-vac)/p+1));
                }
            }
            
        }
    }
}
