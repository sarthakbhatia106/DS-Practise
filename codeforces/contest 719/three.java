import java.io.*;
public class three {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String str=br.readLine();
            int n=Integer.parseInt(str); 
            if(n<=2){
                if(n==1){
                    System.out.println(1);
                }else{
                    System.out.println(-1);
                }
            }else{
                int [][]arr=new int[n][n];
                int count=1;
    
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if((i+j)%2==0){
                            arr[i][j]=count;
                            count++;
                        }
                    }
                }
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if((i+j)%2==1){
                            arr[i][j]=count;
                            count++;
                        }
                    }
                }
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        System.out.print(arr[i][j]+" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
