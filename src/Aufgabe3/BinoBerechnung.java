package Aufgabe3;

import java.util.Scanner;


public class BinoBerechnung {

    static int n;
    static int k;


    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);
        WorkerThread worker = new WorkerThread((n = eingabe.nextInt()),k = eingabe.nextInt());
        worker.run();

      //  ber.run();
      //  System.out.println(ergebnis);

        }

    /*    boolean pruefung = false;
        do {

            System.out.println("n Wert zwischen 0 und 21 eingeben");

            n = eingabe.nextInt();

            if (n >= 0 && n <= 21)
                pruefung = true;

        }while (pruefung == false);


        System.out.println("k Wert eingeben");
        k = eingabe.nextInt();



        System.out.println(berechnung(n,k));





     static double berechnung(int n, int k){

        if (k==0 || n == k ){
            return 1;
        }
        else if (k>n)
            return 0;
        else
        return berechnung(n - 1, k - 1) + berechnung(n - 1, k);

     }
*/

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
        if (k == 0 || n == k) {
            ergebnis = 1;
        } else if (n < k)
            ergebnis = 0;

        else {

            worker2 = new WorkerThread(n - 1, k - 1);
            worker3 = new WorkerThread(n - 1, k);
            worker2.run();
            worker3.run();

/*
        try {
                worker2.join();
                worker3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
*/
            ergebnis = worker2.ergebnis + worker3.ergebnis;

        }


    }
}

