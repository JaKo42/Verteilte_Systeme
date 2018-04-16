package Aufgabe3;

import java.util.Scanner;

public class BinoBerechnung {



    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);

        int n;
        int k;

        boolean pruefung = false;
        do {

            System.out.println("n Wert zwischen 0 und 21 eingeben");

            n = eingabe.nextInt();

            if (n >= 0 && n <= 21)
                pruefung = true;

        }while (pruefung == false);


        System.out.println("k Wert eingeben");
        k = eingabe.nextInt();

        System.out.println(berechnung(n,k));

    }


    static double berechnung(int n, int k){

        if (k==0 || n == k ){
            return 1;
        }
        return berechnung(n-1, k-1) + berechnung(n-1, k);

    }

}
