// import java.io.*;
import java.util.*;
public class distanceVector {
    static int graph[][];
    static int via[][];
    static int rt[][];
    static int v;
    static int e;

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        v = 4;
        e = 5;
        graph = new int[v][v];
        via = new int[v][v];
        rt = new int[v][v];
        for (int i = 0; i < v; i++) 
            for (int j = 0; j < v; j++) 
                if (i == j) 
                    graph[i][j] = 0;
                 else 
                    graph[i][j] = 9999;
  
        for (int i = 0; i < e; i++) {
            System.out.println("\nPlease enter data for Edge " + (i + 1) + ":");
            System.out.print("Source: ");
            int s = scn.nextInt();
            System.out.print("Destination: ");
            int d = scn.nextInt();
            System.out.print("Cost: ");
            int c = scn.nextInt();
            graph[s - 1][d - 1] = c;
            graph[d - 1][s - 1] = c;
        }

        System.out.print("\nEnter Source Node : ");
        int src = scn.nextInt();
        System.out.print("Enter destination node : ");
        int dest = scn.nextInt();
        dvr_calc_disp("\nThe initial min distance b/w src and dest : ", src - 1, dest - 1);
        System.out.print("\nPlease enter the Source Node for the edge whose cost has changed: ");
        int s = scn.nextInt();
        System.out.print("Please enter the Destination Node for the edge whose cost has changed: ");
        int d = scn.nextInt();
        System.out.print("Please enter the new cost: ");
        int c = scn.nextInt();
        graph[s - 1][d - 1] = c;
        graph[d - 1][s - 1] = c;
        dvr_calc_disp("\nThe final min distance b/w src and dest : ", src - 1, dest - 1);
        scn.close();
    }

    static void dvr_calc_disp(String message, int src, int dest) {
        init_tables();
        update_tables();
        System.out.print(message);
        print_tables(src, dest);
    }

    static void update_table(int source) {
        for (int i = 0; i < v; i++) 
            if (graph[source][i] != 9999) {
                int dist = graph[source][i];
                for (int j = 0; j < v; j++) {
                    int inter_dist = rt[i][j];
                    if (via[i][j] == source) 
                        inter_dist = 9999;
                    if (dist + inter_dist < rt[source][j]) {
                        rt[source][j] = dist + inter_dist;
                        via[source][j] = i;
                    }
                }
            }
    }

    static void update_tables() {
        int k = 0;
        for (int i = 0; i < 4 * v; i++) {
            update_table(k);
            k++;
            if (k == v)     k = 0;
        }
    }
    static void init_tables() {
        for (int i = 0; i < v; i++) 
            for (int j = 0; j < v; j++) {
                if (i == j) {
                    rt[i][j] = 0;
                    via[i][j] = i;
                } else {
                    rt[i][j] = 9999;
                    via[i][j] = 100;
                }
            }
    }
    
static void print_tables(int src, int dest) {
        for (int i = 0; i < v; i++) 
            for (int j = 0; j < v; j++) 
                if (i == src && j == dest) 
                    System.out.print(rt[i][j]);
    }

}
