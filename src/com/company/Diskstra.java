package com.company;

import java.util.*;

class Pair<F extends Integer,S extends Integer> implements Comparable{
   public F first;
   public S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" +first +
                "," + second +
                ')';
    }

    @Override
    public int compareTo(Object o) {
        return first.compareTo(0);
    }
}
public class Diskstra {
    List<List<Pair<Integer,Integer>>> adj =  new LinkedList<>();
    Queue<Pair<Integer,Integer>> queue = new PriorityQueue<>();
    int node, edges;
    private boolean[] visited;
    public void takeInput(){
        Scanner sc = new Scanner(System.in);
        String inputNodeAndEdege = sc.nextLine();
        node = Integer.parseInt(inputNodeAndEdege.split(" ")[0]);
        edges = Integer.parseInt(inputNodeAndEdege.split(" ")[1]);
        for (int i = 0; i < node; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            String s = sc.nextLine();
            String[] num = s.split(" ");
            int a = Integer.parseInt(num[0]);
            int b = Integer.parseInt(num[1]);
            int c = Integer.parseInt(num[2]);
            adj.get(a).add(new Pair<>(b,c));
        }
       printTheGraph(adj);
    }
    public void dijkstra(int src){
        int[] dis = new int[10];
        visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
             dis[i] = Integer.MAX_VALUE;
             visited[i] =false;

        }
        dis[src] = 0;
        queue.add(new Pair<>(dis[src],src));
        while (!queue.isEmpty()){
            int u = queue.poll().getSecond();
            if (visited[u]) continue;
            visited[u]= true;
            for (int i = 0; i < adj.get(u).size(); i++) {
                Integer v = adj.get(u).get(i).first;
                Integer uToVCost = adj.get(u).get(i).second;

                if (dis[v] > dis[u]+ uToVCost){
                    dis[v] = dis[u] + uToVCost;
                    queue.add(new Pair<>(-dis[v],v));
                }
            }

        }
        for (int i = 0; i <adj.size(); i++) {
            System.out.println(" ("+i+","+dis[i]+")");
        }

    }
    public void printTheGraph(List<List<Pair<Integer,Integer>>> adj){
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("\nvertex "+i +": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print("-> "+ adj.get(i).get(j).toString());
            }
            System.out.println();

        }
    }



    public Diskstra() {
    takeInput();
    dijkstra(1);
    }

    public static void main(String[] args) {
        new Diskstra();
    }
}
/*
9 14
1 2 4
1 8 8
2 3 8
2 8 11
3 4 7
3 9 2
3 6 4
4 5 9
4 6 14
5 6 10
6 7 2
7 8 1
7 9 6
8 9
 */
