package Stack;

import java.util.*;

public class kStacks{
    public static class stack{
        int n;
        int k;
        int free;
        int []top;
        int []arr;
        int []next;

        public stack(int n,int k){
            this.n=n;
            this.k=k;
            free=0;

            top=new int[k];
            arr=new int[n];
            next=new int[n];

            Arrays.fill(top, -1);

            for(int i=0;i<n-1;i++){
                next[i]=i+1;
            }
            next[n-1]=-1;
        }

        public boolean isFull(){
            return free==-1;
        }
        public boolean isEmpty(int sn){
            return top[sn]==-1;
        }

        public void push(int val,int sn){

            if(isFull()){
                System.out.println("Stack full");
                return;
            }

            int i=free;

            free=next[i];

            arr[i]=val;

            next[i]=top[sn];
            top[sn]=i;
        
        }
        public int pop(int sn){
            if(isEmpty(sn)){
                System.out.println("Stack is empty");
                return -1;
            }
            int i=top[sn];
            int ret=arr[i];
            top[sn]=next[i];

            next[i]=free;
            free=i;

            return ret;
        }

    }
    public static void main(String[] args) {

        int n=10;
        int k=3;

        stack st=new stack(n,k);

        st.push(15, 2);
        st.push(45, 2);
  
        // Let us put some items in stack number 1
        st.push(17, 1);
        st.push(49, 1);
        st.push(39, 1);
  
        // Let us put some items in stack number 0
        st.push(11, 0);
        st.push(9, 0);
        st.push(7, 0);
  
        System.out.println("Popped element from stack 2 is " + st.pop(2));
        System.out.println("Popped element from stack 1 is " + st.pop(1));
        System.out.println("Popped element from stack 0 is " + st.pop(0));


        

    }
}