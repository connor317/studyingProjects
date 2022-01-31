package com.connor.GraphSearching;

import java.util.*;

public class GraphSearching {

    static class pair{
        int row,col;
        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private pair startingPair;
    private pair endingPair;
    private final int[][] mgraph;

    public GraphSearching(int[][] graph, int startingRow, int startingCol, int endingRow, int endingCol) {
        mgraph = graph;
        this.startingPair = new pair(startingRow, startingCol);
        this.endingPair = new pair(endingRow, endingCol);
    }

    public void setStartingPair(int startingRow, int startingCol) {
        startingPair = new pair(startingRow, startingCol);
    }
    public void setEndingPair(int endingRow, int endingCol) {
        endingPair = new pair(endingRow, endingCol);
    }

    public int[][] BFS() {
        Queue<pair> queue = new LinkedList<>();
        int[][] path = new int[mgraph.length][mgraph[0].length];
        boolean[][] visited = new boolean[mgraph.length][mgraph[0].length]; // each element defaults to false

        queue.add(startingPair);
        pair current = startingPair;
        visited[startingPair.row][startingPair.col] = true;
        int count = 1;
        while(!queue.isEmpty() && !(endingPair.col == current.col && endingPair.row == current.row)){
            current = queue.poll();
            addAdjacentToQueue(current, visited, queue);
            path[current.row][current.col] = count;
            count++;
        }

        return path;
    }

    private void addAdjacentToQueue(pair current, boolean[][] visited, Queue<pair> queue) {
        //go around clockwise of the current point
        //add up
        if(current.row != 0 && !visited[current.row-1][current.col] &&
                (mgraph[current.row-1][current.col] == 1)) {
            queue.add(new pair(current.row-1, current.col));
            visited[current.row-1][current.col] = true;
        }
        //add right
        if(current.col != mgraph[0].length-1 && !visited[current.row][current.col+1] &&
                (mgraph[current.row][current.col+1] == 1)) {
            queue.add(new pair(current.row, current.col+1));
            visited[current.row][current.col+1] = true;
        }
        //add down
        if(current.row != mgraph.length-1 && !visited[current.row+1][current.col] &&
                (mgraph[current.row+1][current.col] == 1)) {
            queue.add(new pair(current.row+1, current.col));
            visited[current.row+1][current.col] = true;
        }
        //add left
        if(current.col != 0 && !visited[current.row][current.col-1] &&
                (mgraph[current.row][current.col-1] == 1)) {
            queue.add(new pair(current.row, current.col-1));
            visited[current.row][current.col-1] = true;
        }
    }

    public int[][] DFS(){
        boolean[][] visited = new boolean[mgraph.length][mgraph[0].length];
        int[][] path = new int[mgraph.length][mgraph[0].length];
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
        visited[startingPair.row][startingPair.col] = true;

        Stack<pair> toSearch = new Stack<>();
        toSearch.add(startingPair);
        pair current = startingPair;
        int count = 1;
        while(!toSearch.isEmpty() && !(current.row==endingPair.row && current.col==endingPair.col)){
            current = toSearch.pop();
            addAdjacentToStack(current, visited, toSearch);
            path[current.row][current.col] = count;
            count++;
        }
        return path;
    }

    private void addAdjacentToStack(pair current, boolean[][] visited, Stack<pair> toSearch) {
        //add up
        if(current.row != 0 && !visited[current.row-1][current.col] &&
                (mgraph[current.row-1][current.col] == 1)) {
            toSearch.add(new pair(current.row-1, current.col));
            visited[current.row-1][current.col] = true;
        }
        //add right
        if(current.col != mgraph.length-1 && !visited[current.row][current.col+1] &&
                (mgraph[current.row][current.col+1] == 1)) {
            toSearch.add(new pair(current.row, current.col+1));
            visited[current.row][current.col+1] = true;
        }
        //add down
        if(current.row != mgraph[current.col].length-1 && !visited[current.row+1][current.col] &&
                (mgraph[current.row+1][current.col] == 1)) {
            toSearch.add(new pair(current.row+1, current.col));
            visited[current.row+1][current.col] = true;
        }
        //add left
        if(current.col != 0 && !visited[current.row][current.col-1] &&
                (mgraph[current.row][current.col-1] == 1)) {
            toSearch.add(new pair(current.row, current.col-1));
            visited[current.row][current.col-1] = true;
        }
    }

    public int[][] findIslands(){
        int[][] newGraph;
        int[][] ret = mgraph.clone();
        for(int i = 0; i < mgraph.length; i++) {
            setEndingPair(-1,-1); //set ending pair to an unreachable value
            if(mgraph[0][i] == 1) {
                setStartingPair(0,i);
                newGraph = BFS();
                for(int row = 0; row < newGraph.length; row++) {
                    for(int col = 0; col < newGraph[row].length; col++) {
                        if(newGraph[row][col] != 0) {
                            ret[row][col] = 0;
                        }
                    }
                }
            }
            if(mgraph[i][0] == 1) {
                setStartingPair(i,0);
                newGraph = BFS();
                for(int row = 0; row < newGraph.length; row++) {
                    for(int col = 0; col < newGraph[row].length; col++) {
                        if(newGraph[row][col] != 0) {
                            ret[row][col] = 0;
                        }
                    }
                }
            }
            if(mgraph[i][mgraph[0].length-1] == 1) {
                setStartingPair(i,mgraph[0].length-1);
                newGraph = BFS();
                for(int row = 0; row < newGraph.length; row++) {
                    for(int col = 0; col < newGraph[row].length; col++) {
                        if(newGraph[row][col] != 0) {
                            ret[row][col] = 0;
                        }
                    }
                }
            }
            if(mgraph[mgraph.length-1][i] == 1) {
                setStartingPair(mgraph.length-1,i);
                newGraph = BFS();
                for(int row = 0; row < newGraph.length; row++) {
                    for(int col = 0; col < newGraph[row].length; col++) {
                        if(newGraph[row][col] != 0) {
                            ret[row][col] = 0;
                        }
                    }
                }
            }
        }
        return ret;
    }
}


