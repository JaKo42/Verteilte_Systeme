package Aufgabe2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//Source:https://www.java-forum.org/thema/matrixen-berechnen-nach-worker-master-paradigma-mit-threads.179440/


public class MatrixList implements Iterable<Matrix> {

   Queue<Matrix> qM = new LinkedList<>();

    //TODO die 2 Matrizen initialisieren ...hier oder im Programm? Vielleicht auch mit scanner?
   public MatrixList(){
        for (int i = 0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                this.qM.add(new Matrix(i, j));
            }
        }
    }




    @Override
    public Iterator<Matrix> iterator() {
        return qM.iterator();
    }
}
