package Backtracking;
import java.util.*;

public class magnets {

    public static boolean solution(char[][] arr, int[] top, int[] left, int[] right, int[] bottom, char[][] ans,
            int row, int col) {

        if (row == arr.length) {
            if(isValid(ans,top,left,right,bottom)){
                return true;
            }
            return false;
        }
        int nrow = row;
        int ncol = col;

        if (col == arr[0].length - 1) {
            nrow++;
            ncol = 0;
        } else {
            ncol++;
        }

        if (ans[row][col] == 'X') {
            if (col + 1 < arr[0].length && arr[row][col] == 'L' && arr[row][col + 1] == 'R') {

                if (isSafe(ans, top, left, right, bottom, row, col, '+')
                        && isSafe(ans, top, left, right, bottom, row, col + 1, '-')) {
                    ans[row][col] = '+';
                    ans[row][col + 1] = '-';

                    boolean flag1 = solution(arr, top, left, right, bottom, ans, nrow, ncol);
                    if (flag1 == true) {
                        return true;
                    }

                    ans[row][col] = 'X';
                    ans[row][col + 1] = 'X';
                }

                if (isSafe(ans, top, left, right, bottom, row, col, '-')
                        && isSafe(ans, top, left, right, bottom, row, col + 1, '+')) {
                    ans[row][col] = '-';
                    ans[row][col + 1] = '+';

                    boolean flag2 = solution(arr, top, left, right, bottom, ans, nrow, ncol);
                    if (flag2 == true) {
                        return true;
                    }

                    ans[row][col] = 'X';
                    ans[row][col + 1] = 'X';
                }
            }
            if (row + 1 < arr.length && arr[row][col] == 'T' && arr[row + 1][col] == 'B') {
                if (isSafe(ans, top, left, right, bottom, row, col, '+')
                        && isSafe(ans, top, left, right, bottom, row + 1, col, '-')) {
                    ans[row][col] = '+';
                    ans[row + 1][col] = '-';

                    boolean flag1 = solution(arr, top, left, right, bottom, ans, nrow, ncol);
                    if (flag1 == true) {
                        return true;
                    }

                    ans[row][col] = 'X';
                    ans[row][col + 1] = 'X';
                }

                if (isSafe(ans, top, left, right, bottom, row, col, '-')
                        && isSafe(ans, top, left, right, bottom, row + 1, col, '+')) {
                    ans[row][col] = '-';
                    ans[row + 1][col] = '+';

                    boolean flag2 = solution(arr, top, left, right, bottom, ans, nrow, ncol);
                    if (flag2 == true) {
                        return true;
                    }

                    ans[row][col] = 'X';
                    ans[row][col + 1] = 'X';
                }
            }
        }

        boolean flag3 = solution(arr, top, left, right, bottom, ans, nrow, ncol);
        if (flag3)
            return true;

        return false;
    }

    private static boolean isValid(char[][] ans, int[] top, int[] left, int[] right, int[] bottom) {

        for(int i=0;i<ans.length;i++){
            if(left[i]!=-1 && rowCount(ans, i, 0, '+')!=left[i]){
                return false;
            }
        }

        for(int i=0;i<ans.length;i++){
            if(right[i]!=-1 && rowCount(ans, i, 0, '-')!=right[i]){
                return false;
            }
        }

        for(int i=0;i<ans[0].length;i++){
            if(top[i]!=-1 && colCount(ans, 0, i, '+')!=top[i]){
                return false;
            }
        }

        for(int i=0;i<ans[0].length;i++){
            if(bottom[i]!=-1 && colCount(ans, 0, i, '-')!=bottom[i]){
                return false;
            }
        }
        return true;
    }

    private static boolean isSafe(char[][] ans, int[] top, int[] left, int[] right, int[] bottom, int row, int col,
            char ch) {

        if (ans[row][col] != 'X')
            return false;
        if (row - 1 >= 0 && ans[row - 1][col] == ch) {
            return false;
        }
        if (row + 1 < ans.length && ans[row + 1][col] == ch) {
            return false;
        }
        if (col - 1 >= 0 && ans[row][col - 1] == ch) {
            return false;
        }
        if (col + 1 < ans[0].length && ans[row][col + 1] == ch) {
            return false;
        }

        int rowChCount = rowCount(ans, row, col, ch);
        int colChCount = colCount(ans, row, col, ch);

        if (ch == '+') {
            if (top[col] != -1 && colChCount >= top[col]) {
                return false;
            }

            if (left[row] != -1 && rowChCount >= left[row]) {
                return false;
            }
        } else {
            if (bottom[col] != -1 && colChCount >= bottom[col]) {
                return false;
            }

            if (right[row] != -1 && rowChCount >= right[row]) {
                return false;
            }

        }

        return true;
    }

    public static int rowCount(char[][] ans, int row, int col, char ch) {

        int count = 0;
        for (int j = 0; j < ans[0].length; j++) {
            if (ans[row][j] == ch) {
                count++;
            }
        }
        return count;
    }

    public static int colCount(char[][] ans, int row, int col, char ch) {

        int count = 0;
        for (int j = 0; j < ans[0].length; j++) {
            if (ans[j][col] == ch) {
                count++;
            }
        }
        return count;
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        char[][] arr = new char[m][n];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = scn.nextInt();
        }
        int[] left = new int[m];
        for (int i = 0; i < m; i++) {
            left[i] = scn.nextInt();
        }
        int[] right = new int[m];
        for (int i = 0; i < m; i++) {
            right[i] = scn.nextInt();
        }
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            bottom[i] = scn.nextInt();
        }

        char [][]ans=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]='X';
            }
        }

        boolean flag= solution(arr, top, left, right, bottom, ans, 0, 0);
        if(flag==false){
            System.out.println("No solution");
        }

        scn.close();
    }

}