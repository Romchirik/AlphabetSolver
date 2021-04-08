package ru.nsu.titov;

import ru.nsu.titov.graph.Graph;
import ru.nsu.titov.graph.Vertex;

import java.util.Arrays;
import java.util.Scanner;

public final class Main {

    static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static private String[] names;
    private String distortedAlphabet;
    static Graph graph = new Graph();

    public static void main(String[] args) {
        int numNames = 0;
        alphabet.chars().forEach(ch -> graph.addVertex(new Vertex((char) ch)));

        Scanner scanner = new Scanner(System.in);
        numNames = scanner.nextInt();
        names = new String[numNames];

        for (int i = 0; i < numNames; i++) {
            String tmpName = scanner.next();
            names[i] = tmpName;
        }

        for (int i = 0; i < numNames; i++) {
            for (int j = i; j < numNames; j++) {
                int firstDiff = findFirstDiff(names[i], names[j]);
                if (firstDiff != -1) {
                    graph.addEdge(names[i].charAt(firstDiff) - 'a', names[j].charAt(firstDiff) - 'a');
                }
            }
        }

        if (graph.sort()) {
            Vertex[] tmp = graph.getSortedArray();
            for(int i = 0; i < graph.getNumVertexes(); i++){
                System.out.print(tmp[i].getLabel());
            }
        } else {
            System.out.println("Impossible");
        }

    }

    //string1 > string2
    public static int findFirstDiff(String string1, String string2) {
        int minLen = Math.min(string1.length(), string2.length());
        for (int i = 0; i < minLen; i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                return i;
            }
        }

        return -1;
    }
}
