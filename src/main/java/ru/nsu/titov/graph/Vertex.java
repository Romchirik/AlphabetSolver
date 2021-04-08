package ru.nsu.titov.graph;

public final class Vertex {
    private char label;
    private boolean valid = true;

    public Vertex(char label) {
        this.label = label;
    }

    public char getLabel() {
        return label;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
