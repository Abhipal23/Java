package org.abhishek.java.StroageGraph;

import java.util.ArrayList;

public class AdjacencyList {
    public static void main(String[] args) {
        // it is another way to store graph

        int n =3, m=3;

        ArrayList<ArrayList<Integer>> adjacencyList =new ArrayList<ArrayList<Integer>>();

        // n+1 ArrayList empty
        for(int i =0; i<=n; i++) adjacencyList.add(new ArrayList<>());

        //edge 1-2
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        // edge 2-3
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(4);


        // edge 1-3
        adjacencyList.get(1).add(3);
        adjacencyList.get(3).add(1);

        // edge 1-3 if direted
//        adjacencyList.get(1).add(3);





        // print list
        for(int i =1; i<n; i++){
              for(int j =0; j<adjacencyList.get(i).size(); j++){
                  System.out.print(adjacencyList.get(i).get(j)+" ");
              }
            System.out.println();
        }

    }
}
