package Backtracking;
import java.util.*;

public class crossWord {

	public static void solution(char[][] arr, String[] words, int vidx){
		//write your code here

        if(vidx==words.length){
            print(arr);
            return;
        }
		
		String word=words[vidx];
		
		for(int i=0;i<arr.length;i++){
		    for(int j=0;j<arr[0].length;j++){
		        if(arr[i][j]=='-' || arr[i][j]==word.charAt(0)){
		            
		            if(checkVertical(arr,word,i,j)){
		                boolean []vis=new boolean [word.length()];
		                placeVertical(arr,word,i,j,vis);
		                solution(arr,words,vidx+1);
                        removeVertical(arr,word,i,j,vis);
		            }

                    if(checkHorizontal(arr,word,i,j)){
                        boolean []vis=new boolean [word.length()];
                        placeHorizontal(arr,word,i,j,vis);
                        solution(arr, words, vidx+1);
                        removeHorizontal(arr,word,i,j,vis);
                    }
		        }
		    }
		}

	}

    
    private static void removeVertical(char[][] arr, String word, int row, int col, boolean[] vis) {

        int i=row;
        int idx=0;

        while(idx<word.length()){
            if(vis[idx]==true){
                arr[i][col]='-';
            }
            idx++;
            i++;
        }
    }
    
    private static void removeHorizontal(char[][] arr, String word, int row, int col, boolean[] vis) {
        int i=col;
        int idx=0;

        while(idx<word.length()){
            if(vis[idx]==true){
                arr[row][i]='-';
            }
            idx++;
            i++;
        }
    }
    
    private static void placeVertical(char[][] arr, String word, int row, int col, boolean[] vis) {

        int i=row;
        int idx=0;

        while(idx<word.length()){
            if(arr[i][col]=='-'){
                vis[idx]=true;
            }
            arr[i][col]=word.charAt(idx);
            idx++;
            i++;
        }
    }
    
    
    private static void placeHorizontal(char[][] arr, String word, int row, int col, boolean[] vis) {
        int i=col;
        int idx=0;

        while(idx<word.length()){
            if(arr[row][i]=='-'){
                vis[idx]=true;
            }
            arr[row][i]=word.charAt(idx);
            idx++;
            i++;
        }
    }

    private static boolean checkVertical(char[][] arr, String word, int row, int col) {
        int i=row;

        while(i-row<word.length()){
            if(i==arr.length){
                return false;
            }

            if(arr[i][col]=='-' || arr[i][col]==word.charAt(i-row)){
                i++;
            }else{
                return false;
            }
        }
        return true;
    }


    private static boolean checkHorizontal(char[][] arr, String word, int row, int col) {
        int i=col;

        while(i-col<word.length()){
            if(i==arr[0].length){
                return false;
            }

            if(arr[row][i]=='-' || arr[row][i]==word.charAt(i-col)){
                i++;
            }else{
                return false;
            }
        }
        return true;
    }


    public static void print(char[][] arr){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}

        solution(arr, words, 0);
        scn.close();
	}
}