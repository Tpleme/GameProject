package org.acadmeiadecodigo.gnunas.keepitclean;

public class Position {
    private int cols,rows;

    public Position (int cols,int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}
