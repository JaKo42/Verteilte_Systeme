package Aufgabe2.Master_Worker;

import java.util.ArrayList;
import java.util.Stack;

class Slave extends Thread {

  int[][] matrixA, matrixB, matrixC;
  public Stack<Matrix> mList;
  public int counter = 0;

  public Slave(int[][] matrixA, int[][] matrixB, int[][] matrixC, Stack<Matrix> mlist) {
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

    for (counter = this.counter; counter < counter + 1; counter++ ){
      mList.get(counter);
      System.out.println(counter);
      if () {
      }

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