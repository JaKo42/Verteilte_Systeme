package Aufgabe2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//Source:https://www.java-forum.org/thema/matrixen-berechnen-nach-worker-master-paradigma-mit-threads.179440/


public class MatrixList implements Iterable<Matrix>{

    Queue<Matrix> qM = new LinkedList<>();

    public MatrixList() {
        this.init();
    }

    public void init() {
        for(int i = 0; i < 5;i++) {
            for(int j = 0; j < 5;j++) {
                this.qM.add(new Matrix(i, j));
            }
        }
    }

    public boolean isEmpty(){
        return qM.isEmpty();
    }

    public synchronized Matrix getfirstMatrix(){

        return qM.poll();

    }

    @Override
    public Iterator<Matrix> iterator() {

        return qM.iterator();
    }

}