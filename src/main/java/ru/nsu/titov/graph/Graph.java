package ru.nsu.titov.graph;

public final class Graph {
    private final int MAX_VERTEXES = 26;
    private int numVertexes = 0;

    private final Vertex[] vertexList = new Vertex[MAX_VERTEXES];
    private final boolean[][] matrix = new boolean[MAX_VERTEXES][MAX_VERTEXES];
    private final Vertex[] sortedArray = new Vertex[MAX_VERTEXES];

    public Graph() {
        for (int i = 0; i < MAX_VERTEXES; i++)
            for (int k = 0; k < MAX_VERTEXES; k++)
                matrix[i][k] = false;
    }

    public void addVertex(Vertex vertex) {
        vertexList[numVertexes] = vertex;
        numVertexes++;
    }

    public void addEdge(int start, int end) {
        matrix[start][end] = true;
    }

    public boolean sort() {
        int numVertexesRemain = numVertexes;
        while (numVertexesRemain > 0) {
            int currentVertex = findNoChildVertex();
            if (currentVertex == -1) {
                return false;
            }

            sortedArray[numVertexesRemain - 1] = vertexList[currentVertex];
            vertexList[currentVertex].setValid(false);
            numVertexesRemain--;
        }
        return true;
    }

    public Vertex[] getSortedArray() {
        return sortedArray;
    }

    private int findNoChildVertex() {
        for (int i = 0; i < numVertexes; i++) {
            boolean edgeFound = false;
            if (vertexList[i].isValid()) {
                for (int j = 0; j < numVertexes; j++) {
                    if (vertexList[j].isValid()) {
                        if (matrix[i][j]) {
                            edgeFound = true;
                            break;
                        }
                    }
                }
            } else {
                continue;
            }

            if (!edgeFound) {
                return i;
            }
        }
        return -1;
    }


    public int getNumVertexes() {
        return numVertexes;
    }
}