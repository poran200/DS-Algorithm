package com.company;

import java.util.*;

public class GraphInputAndDfs {
    static int v = 9;
    static ArrayList<ArrayList<Integer>> adList = new ArrayList<>(v);
    static boolean[] visited;


    public static void main(String[] args) {
        for (int i = 0; i < v; i++) {
            adList.add(new ArrayList<>());
        }
        visited = new boolean[v];

        addEdge(adList, 2, 1);
        addEdge(adList, 2, 3);
        addEdge(adList, 1, 4);
        addEdge(adList, 3, 5);
        addEdge(adList, 3, 7);
        addEdge(adList, 5, 6);
        addEdge(adList, 5, 7);
        addEdge(adList, 7, 8);
        addEdge(adList, 6, 8);
        printGraph(adList);
//      dfs(2);
//        bfs(2);
//        System.out.println("Is their any direct path ->  2 and 1 = " +isReachableWithDirectPath(2,1));
//        System.out.println("Is their any direct path ->  2 and 4 = " +isReachableWithDirectPath(2,4));
        System.out.println("\nIs their any  path ->  2 and 0 = " +isReachableWithAnyPath(2,0));
        System.out.println("\nIs their any  path ->  7 and 4 = " +isReachableWithAnyPath(7,4));
    }

    static void dfs(int vertex) {
        visited[vertex] = true;
        System.out.println(vertex + " ");
        for (int i = 0; i < adList.get(vertex).size(); i++) {
            Integer a = adList.get(vertex).get(i);
            if (!visited[a])
                dfs(a);
        }
    }

    static void bfs(int sourceVertex) {
        int[] dist = new int[v];
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < adList.size(); i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[sourceVertex] = 0;
        queue.add(sourceVertex);
        while (!queue.isEmpty()) {
            Integer s = queue.poll();

            for (int i = 0; i < adList.get(s).size(); i++) {
                Integer u = adList.get(s).get(i);
                if (dist[u] > dist[s] + 1) {
                    dist[u] = dist[s] + 1;
                    queue.add(u);
                }
            }
        }
        for (int i = 0; i < adList.size(); i++) {
            System.out.printf("distance from source %d to %d nth node is %d\n", sourceVertex, i, dist[i]);
        }
    }
    static boolean isReachableWithDirectPath(int sourceVertex, int d){

        Queue<Integer> queue = new PriorityQueue<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        while (!queue.isEmpty()){
           int s = queue.poll();

            for (int i = 0; i < adList.get(s).size(); i++) {
                Integer n = adList.get(s).get(i);
                if (n == d)
                           return true;
            }

        }
        return false;
    }
    static boolean isReachableWithAnyPath(int sourceVertex, int d){
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new PriorityQueue<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        while (!queue.isEmpty()){
            int s = queue.poll();

            for (int i = 0; i < adList.get(s).size(); i++) {
                Integer n = adList.get(s).get(i);
                System.out.print( n +" ");
                if (n == d)
                    return true;
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }
        return false;
    }


    public GraphInputAndDfs() {

    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adList, int a, int b) {
        adList.get(a).add(b);
        adList.get(b).add(a);
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> adList) {
        for (int i = 0; i < adList.size(); i++) {
            System.out.print("\nvertex " + i + ":");
            for (int j = 0; j < adList.get(i).size(); j++) {
                System.out.print("-> " + adList.get(i).get(j));
            }
            System.out.println();
        }
    }
}
