package org.abhishek.java.StroageGraph;

public class AdjacencyMatrix {

// space will be (n*n)
    public static void main(String[] args) {
        // as of now graph is undirected means if there is edge 1-2 it means there will be edge 2-1
        int n=3, m =3;

        // declare matrix
        int  matrix [][] = new int[n+1][n+1];

        // edge 1-2
        matrix[1][2]=1;
        matrix[2][1]=1;

        // edge 1-3
        matrix[1][3]=1;
        matrix[3][1]=1;

        // edge 2-3
        matrix[3][2]=1;
        matrix[2][3]=1;


    }

}
