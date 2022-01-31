package com.connor.pathFinding;

import java.util.PriorityQueue;

public class Dijkstras {
    int[][] graph;
    int target;
    int start;
    String[] paths;
    public Dijkstras(int[][] graph, int start, int target) {
        this.graph = graph;
        this.start = start;
        this.target = target;
        this.paths = new String[graph.length];
    }
    public int solve(){
        int[] distances = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        visited[start] = true;
        distances[start] = 0;

        PriorityQueue<Integer> nodesToVisit = new PriorityQueue<>();

        nodesToVisit.add(start);
        paths[start] = "";
        while (!nodesToVisit.isEmpty()) {
            int nodeVisiting = nodesToVisit.poll();
            for(int i = 0; i < graph.length; i++) {
                if (graph[nodeVisiting][i] != -1) {
                    if (graph[nodeVisiting][i] + distances[nodeVisiting] < distances[i]) {
                        if(!paths[nodeVisiting].equals("")) {
                            paths[i] = paths[nodeVisiting] + " " + nodeVisiting;
                        } else {
                            paths[i] = String.valueOf(nodeVisiting);
                        }
                        distances[i] = graph[nodeVisiting][i] + distances[nodeVisiting];
                    }
                    if (!visited[i]) {
                        nodesToVisit.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
        paths[start] = "start";

        return distances[target];
    }

    public String[] getGraphConnections() {
        String[] ret = new String[graph.length];
        for (int i = 0; i < graph.length; i++) {
            ret[i] = "";
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != -1) {
                    if (ret[i].length() != 0) {
                        ret[i] += " " + (char)(j+97); //get the character represenation of the number
                    } else {
                        ret[i] += (char)(j+97);
                    }
                }
            }
        }
        return ret;
    }

    public String[] getPaths(){
        return paths;
    }
}

