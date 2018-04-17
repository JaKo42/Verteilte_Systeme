package Aufgabe3;

import java.util.Scanner;


public class BinoBerechnung {

    static int n;
    static int k;
    static double ergebnis;


    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);

        //Eingabe der Parameter
        //Prüfung ob richtige Parameter eingegeben werden
        boolean pruefung = false;
        do {

            System.out.println("n Wert zwischen 0 und 21 eingeben");

            n = eingabe.nextInt();

            if (n >= 0 && n <= 21)
                pruefung = true;

        }while (!pruefung);

        System.out.println("k wert eingeben");
        k = eingabe.nextInt();

        //Erstellung des ersten Worker

        WorkerThread worker = new WorkerThread(n,k);
        worker.start();
        try {
            worker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Ausgabe des Ergebnisses
        System.out.println("Ergebnis: " + worker.ergebnis);


    }
}


class WorkerThread extends Thread {

    int n;
    int k;
    double ergebnis;

    public WorkerThread(int n, int k) {
        this.n = n;
        this.k = k;
    }


    public void run() {
        WorkerThread worker2;
        WorkerThread worker3;
        //Überprüfung der Rechenregeln
        if (k == 0 || n == k) {
            ergebnis = 1;
        } else if (n < k)
            ergebnis = 0;

        else {
            //Aufteilung der Arbeit
            worker2 = new WorkerThread(n - 1, k - 1);
            worker3 = new WorkerThread(n - 1, k);
            worker2.start();
            worker3.start();
            try{
                worker2.join();
                worker3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Summieren der Ergebnisse
            ergebnis = worker2.ergebnis + worker3.ergebnis;

        }


    }
}

