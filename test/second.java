import java.util.*;
public class second {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();

        int [][]matrix=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=scn.nextInt();
            }
        }

        int []ans=spiralTraversal(matrix);

        System.out.println("Spiral Traversal: ");
        for(int i: ans){
            System.out.print(i+" ");
        }
    }
    public static int [] spiralTraversal(int [][]matrix){
        int n=matrix.length;
        int m=matrix[0].length;

        int []ans=new int[n*m];

        int idx=0;

        int minRow=0;
        int minCol=0;
        int maxRow=n-1;
        int maxCol=m-1;

        while(idx<n*m){

            for(int i=minCol;i<=maxCol;i++){
                ans[idx++]=matrix[minRow][i];
            }
            minRow++;

            for(int i=minRow;i<=maxRow;i++){
                ans[idx++]=matrix[i][maxCol];
            }
            maxCol--;

            for(int i=maxCol;i>=minCol;i--){
                ans[idx++]=matrix[maxRow][i];
            }
            maxRow--;

            for(int i=maxRow;i>=minRow;i--){
                ans[idx++]=matrix[i][minCol];
            }
            minCol++;
        }
        return ans;
    }
}
