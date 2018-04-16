package Aufgabe2;

import java.util.ArrayList;

public class Master {
    public int slaveCount = 5;
    public MatrixList res = new MatrixList();
    public Slave[] slaves = new Slave[slaveCount];

    public void run() throws InterruptedException {

        int[][] matrixA = {{1,-2,3,4,-1},{-2,3,0,1,2},{4,-1,2,1,-2},{-2,1,3,-1,3},{0,2,-1,2,4}};
        int[][] matrixB = {{2,-4,-1,1,-2},{-1,1,-2,2,1},{5,0,3,-2,-4},{1,-2,1,0,2},{2,3,-3,0,0}};

        int[][] matrixC = new int[5][5];


        MatrixList mlist = new MatrixList();

        //slaves setzen
        int z1 = 25 % slaveCount;    //Variable um die restlichen(ungeraden) Koordinaten zuweisen zu können
        int z2 = 25 - z1;    //Variable um die "geraden" Koordinaten zuweisen zu können
        int z3 = 0;            //Zähler für restliche Koordinaten


        for (int j = 0; j < slaveCount; j++) {
            ArrayList<Matrix> aKor1 = new ArrayList<Matrix>();//Liste in jeder Schleife anlegen
            aKor1.clear();//die bereits angelegte Liste zuvor löschen...
            if (z3 < z1) {    //solange es restliche Koordinaten gibt...
                z3++;        //Die ersten Threads arbeiten immer 1x mehr damit die Rechnung bei ungeraden Threads aufgehen kann
                aKor1.add(mlist.getfirstMatrix());
            }

            for (int i = 0; i < (z2 / slaveCount); i++) {  //zuweisung der geraden Koordinaten
                aKor1.add(mlist.getfirstMatrix());

            }
            slaves[j] = new Slave(matrixA, matrixB, matrixC, aKor1);
        }
        for (int i = 0; i < slaveCount; i++) {
            slaves[i].start();
        }
        for (int i = 0; i < slaveCount; i++) {
            slaves[i].join();
        }
        for (int p = 0; p < slaveCount; p++) {
            System.out.println(
                    "Ich bin " + slaves[p+1].getName() + " hat " + slaves[p].getAnzahlArbeit() + " mal berechnet");
        }

        slaves[0].MatrixAusgabe();
    }
}