package com.connor.pathFinding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DijkstrasTest {

    static int[][] graph;
    static Dijkstras solver;
    @BeforeAll
    static void setUp() {
        graph = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                graph[i][j] = -1; // -1 means that they do not connect
            }
        }

        //adjacency matrix - This is a directed graph
        graph[0][1] = 5;
        graph[0][2] = 3;
        graph[0][4] = 2;

        graph[1][3] = 2;

        graph[2][1] = 1;
        graph[2][3] = 1;

        graph[3][0] = 1;
        graph[3][6] = 2;
        graph[3][7] = 1;

        graph[4][0] = 1;
        graph[4][7] = 4;
        graph[4][8] = 7;

        graph[5][1] = 3;
        graph[5][6] = 1;

        graph[6][2] = 3;
        graph[6][8] = 2;

        graph[7][2] = 2;
        graph[7][5] = 2;
        graph[7][6] = 2;

        solver = new Dijkstras(graph, 0, 8);
    }

    @Test
    void solve() {
        int correct = 8;
        Assertions.assertEquals(correct, solver.solve());
    }

    @Test
    void getPaths() {
        String correct = "0 2 3 6";
        Assertions.assertEquals(correct, solver.getPaths()[8]);
    }

    @Test
    void getGraphConnections() {
        String[] correct = new String[graph.length];
        correct[0] = "b c e";
        correct[1] = "d";
        correct[2] = "b d";
        correct[3] = "a g h";
        correct[4] = "a h i";
        correct[5] = "b g";
        correct[6] = "c i";
        correct[7] = "c f g";
        correct[8] = "";
        Assertions.assertArrayEquals(correct, solver.getGraphConnections());
    }
}