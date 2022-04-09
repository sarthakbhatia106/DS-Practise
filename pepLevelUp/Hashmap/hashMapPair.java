package Hashmap;
import java.util.HashMap;

public class hashMapPair {
    public static class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode(){
            Integer xdash=x;
            Integer ydash=y;
            return xdash.hashCode()^ydash.hashCode();
        }

        public boolean equals(Object o){
            if(this==o){
                return true;
            }
            if(o==null){
                return false;
            }

            if(this.getClass()!=o.getClass()){
                return false;
            }

            pair p=(pair)o;
            if(this.x==p.x && this.y==p.y){
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        HashMap<pair,Integer> map=new HashMap();

        pair p1=new pair(10,20);
        pair p2=new pair(10,30);
        pair p3=new pair(10,40);
        map.put(p1, 100);
        System.out.println(map.size());
        map.put(p2, 200);
        System.out.println(map.size());
        map.put(p3, 300);
        System.out.println(map.size());


    }
}
