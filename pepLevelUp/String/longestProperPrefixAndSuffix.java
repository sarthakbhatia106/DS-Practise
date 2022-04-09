package String;

public class longestProperPrefixAndSuffix {
    public static int lps(String str){
        int []lps=new int[str.length()+1];
        int len=0;
        int i=1;

        while(i<str.length()){
            if(str.charAt(i)==str.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len>0){
                    len=lps[len];
                }else{
                    i++;
                }
            }
        }
        return len;
    }
}
