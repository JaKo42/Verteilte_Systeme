package Aufgabe2.Master_Worker;

import java.util.ArrayList;

class Slave extends Thread {

    int[][] matrixA, matrixB, matrixC;
    public static ArrayList<Matrix> mList;
    public static int counter = 0;

    public Slave(int[][] matrixA, int[][] matrixB, int[][] matrixC, ArrayList<Matrix> mlist) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.matrixC = matrixC;
        this.mList = mlist;
    }

    public void run() {
        MatrixBerechnung();
    }

    public synchronized void MatrixBerechnung() {
        /*for (Matrix k : mList) {        //Iteriert über die Koordinatenliste.
            int a = k.getZeile();
            int b = k.getSpalte();

            for (int j = 0; j < 5; j++) {
                matrixC[a][b] += matrixA[a][j] * matrixB[j][b];
            }
            counter++;
        }*/
        while (mList.size()>counter){
            int a = mList.get(counter).zeile;
            int b = mList.get(counter).spalte;


            for (int j = 0; j<5;j++)
            matrixC[a][b]+= matrixA[a][j] * matrixB[j][b];


            counter++;

            System.out.println(counter);
            System.out.println(currentThread());
        }







    }

    public synchronized void MatrixAusgabe() {
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC.length; j++) {
                System.out.print(matrixC[i][j] + " ");
                if (j == matrixC.length - 1) {
                    System.out.println();
                }
            }
        }
    }

    public int getAnzahlArbeit() {
        return counter;
    }
}