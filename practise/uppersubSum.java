import java.util.*;
public class uppersubSum{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();

        int [][]arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        int [][]temp=new int[n][m];
        for(int i=0;i<m;i++){
            temp[0][i]=arr[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                temp[i][j]=arr[i][j]+temp[i-1][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                temp[i][j]+=temp[i][j-1];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
        scn.close();
    }
}