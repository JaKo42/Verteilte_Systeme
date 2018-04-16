package Aufgabe3;

import java.util.Scanner;

public class BinoBerechnung extends Thread {

    static double ergebnis;
    static int n;
    static int k;


    public BinoBerechnung(int n, int k) {
    this.n = n;
    this.k = k;

    }

    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);
        BinoBerechnung ber = new BinoBerechnung(n = eingabe.nextInt(), k = eingabe.nextInt());

        ber.run();
        System.out.println(ergebnis);

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

*/



     static double berechnung(int n, int k){

        if (k==0 || n == k ){
            return 1;
        }


        return berechnung(n - 1, k - 1) + berechnung(n - 1, k);

     }

    @Override
    public synchronized void start() {

        System.out.println(ergebnis = berechnung(n - 1, k - 1));

        System.out.println(ergebnis+= berechnung(n - 1, k));



    }

    @Override
    public void run() {
         System.out.println("thread start");
         start();



    }
}


/*
class AddThread extends Thread{

    int n;
    int k;

    public AddThread(int n, int k) {
        this.n = n;
        this.k = k;
    }

    @Override
    public void run() {


    }
}
*/
