package Hashmap;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class hashMap {
    public static class HashMap<K, V> {
        public class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        LinkedList<HMNode>[] buckets;
        int size;

        public HashMap() {
            size = 0;
            buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public void put(K key, V value) {
            int idx = Hashfunction(key);
            int presIdx = find(idx, key);

            if (presIdx == -1) {
                HMNode n = new HMNode(key, value);
                buckets[idx].addLast(n);
                size++;
            } else {
                HMNode n = buckets[idx].get(presIdx);
                n.value = value;
            }

            double plamda = size * 1.0 / buckets.length;
            if (plamda > 2.0) {
                rehash();
            }
        }

        private void rehash() {
            LinkedList<HMNode>[] arr = buckets;
            buckets = new LinkedList[2 * arr.length];
            for (int i = 0; i < 2 * arr.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            size = 0;
            for (int i = 0; i < arr.length; i++) {
                for (HMNode n : arr[i]) {
                    put(n.key, n.value);
                }
            }
        }

        private int find(int idx, K key) {
            int i = 0;
            for (HMNode n : buckets[idx]) {
                if (n.key.equals(key)) {
                    return i;
                }
                i++;
            }
            return -1;
        }

        private int Hashfunction(K key) {
            int hashcode = Math.abs(key.hashCode());
            int idx = hashcode % buckets.length;
            return idx;
        }

        public V get(K key) {
            int idx = Hashfunction(key);
            int presIdx = find(idx, key);

            if (presIdx == -1) {
                return null;
            } else {
                HMNode n = buckets[idx].get(presIdx);
                return n.value;
            }
        }

        public boolean containsKey(K key) {
            int idx = Hashfunction(key);
            int presIdx = find(idx, key);

            if (presIdx == -1) {
                return false;
            } else {
                return true;
            }
        }

        public int size() {
            return size;
        }

        public V remove(K key) {
            int idx = Hashfunction(key);
            int presIdx = find(idx, key);

            if (presIdx == -1) {
                return null;
            } else {
                HMNode n = buckets[idx].remove(presIdx);
                size--;
                return n.value;
            }
        }

        public ArrayList<K> keyset() {
            ArrayList<K> ans = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                for (HMNode n : buckets[i]) {
                    ans.add(n.key);
                }
            }
            return ans;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}