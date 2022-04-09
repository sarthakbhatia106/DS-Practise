package test;

import java.util.*;
public class balancedParenthesis{
    public static void main(String[] args) {
        // String a="{()}";
        // System.out.println(checkBalancedParenthesis(a));

        // int []arr={-1,-3,2,5};
        // int x=2;
        // findPairs(arr, x);
        // printInterger(5);
        // printInterger("Hello");
    }
    public boolean checkBalancedParenthesis(String str){
        Stack<Character> st=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else{
                if(ch==')' && st.size()>0 && st.peek()=='('){
                    st.pop();
                }else if(ch=='}' && st.size()>0 && st.peek()=='{'){
                    st.pop();
                }else if(ch==']' && st.size()>0 && st.peek()=='['){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.size()==0;
    }
    public static void findPairs(int []arr,int x){
        HashSet<Integer> set=new HashSet<>();

        for(int i: arr){
            int find=x-i;

            if(set.contains(find)){
                System.out.println(i+" , "+(x-i));
                return;
            }
            set.add(i);
        }
    }
    public static final void printInterger(int n){
        // System.out.println(n);
        String a="()()";
        // System.out.println(checkBalancedParenthesis(a));
    }
    // public static final void printInterger(int s){
    //     System.out.println(s);
    // }

}