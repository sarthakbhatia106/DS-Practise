package Tries;

class Trie {
    public class Node{
        char ch;
        boolean eow;
        Node []arr=new Node[26];
        
        public Node(char ch){
            this.ch=ch;
            this.eow=false;
        }
    }
    
    Node root;
    public Trie() {
        root=new Node(' ');
    }
    
    public void insert(String word) {
        Node temp=root;
        
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            
            if(temp.arr[ch-'a']==null){
                Node n=new Node(ch);
                temp.arr[ch-'a']=n;
            }
            temp=temp.arr[ch-'a'];
        }
        temp.eow=true;
    }
    
    public boolean search(String word) {
        Node temp=root;
        
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            
            if(temp.arr[ch-'a']==null){
                return false;
            }
            temp=temp.arr[ch-'a'];
        }
        return temp.eow;
    }
    
    public boolean startsWith(String word) {
        Node temp=root;
        
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            
            if(temp.arr[ch-'a']==null){
                return false;
            }
            temp=temp.arr[ch-'a'];
        }
        return true;
    }
}
