package testings;

import java.util.concurrent.Semaphore;
//from   jav  a  2  s  .  co m
public class Test {
    public static void main(String args[]) {
        Semaphore sem = new Semaphore(2,true);
        new Producer(sem, "A");
        new Consumer(sem, "B");
    }
}
class Shared {
    static int count = 0;
}
class Producer implements Runnable {
    String name;
    Semaphore sem;

    Producer(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }
    public void run() {
        try {
            sem.acquire(1);
            for (int i = 0; i < 5; i++) {
                System.out.println(name + ": " + Shared.count++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        sem.release();
    }
}
class Consumer implements Runnable {
    String name;
    Semaphore sem;
    Consumer(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }
    public void run() {
        try {
            sem.acquire(2);
            for (int i = 0; i < 5; i++) {
                System.out.println(name + ": " + Shared.count--);
                Thread.sleep(1000);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        sem.release();
    }
}
