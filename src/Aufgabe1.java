import java.util.concurrent.Semaphore;


public class Aufgabe1 extends Thread {


 /*   Schreiben Sie ein Multithread-Programm in Java, das die folgenden zeitlichen
    Abhängigkeiten für die Ausführungsaktivitäten der einzelnen Threads einhält.
    Dabei führt der i-te Thread die Aktivität ai (i = 1 - 7) aus
(vgl. Event-Synchronisation mit Semaphoren):*/




















    public static void main(String[] args){

    Semaphore [] sem = new Semaphore[8];

        for (int i = 0; i <sem.length ; i++) {
        sem[i] = new Semaphore(0);
        }
     new Thread_1(sem,"Thread_1");
    /* new Thread_2(sem;"Thread_2");
     new Thread_3(sem;"Thread_3");
     new Thread_4(sem;"Thread_4");
     new Thread_5(sem;"Thread_5");
     new Thread_6(sem;"Thread_6");
     new Thread_7(sem;"Thread_7");   */
    }
}

class Thread_1 extends Thread{

    private Semaphore[] sem;

    public Thread_1(Semaphore[] sem, String name)
    {
        super(name);
        this.sem = sem;
        start();
    }

    private void A1()
    {
        System.out.println("Activity_4 running");
    }

    public void run()
    {
        A1();
        sem[0].v();
        sem[1].v();


    }

}

class Thread_2 extends Thread{

    private Semaphore[] sem;

    public Thread_2(Semaphore[] sem, String name)
    {
        super(name);
        this.sem = sem;
        start();
    }

    private void A1()
    {
        System.out.println("Activity_4 running");
    }

    public void run()
    {
        A1();
        sem[0].v();
        sem[1].v();


    }

}

class Thread_3 extends Thread{

    private Semaphore[] sem;

    public Thread_3(Semaphore[] sem, String name)
    {
        super(name);
        this.sem = sem;
        start();
    }

    private void A1()
    {
        System.out.println("Activity_4 running");
    }

    public void run()
    {
        A1();
        sem[0].v();
        sem[1].v();


    }

}

class Thread_4 extends Thread{

    private Semaphore[] sem;

    public Thread_4(Semaphore[] sem, String name)
    {
        super(name);
        this.sem = sem;
        start();
    }

    private void A1()
    {
        System.out.println("Activity_4 running");
    }

    public void run()
    {
        A1();
        sem[0].v();
        sem[1].v();


    }

}

class Thread_5 extends Thread{

    private Semaphore[] sem;

    public Thread_5(Semaphore[] sem, String name)
    {
        super(name);
        this.sem = sem;
        start();
    }

    private void A1()
    {
        System.out.println("Activity_4 running");
    }

    public void run()
    {
        A1();
        sem[0].v();
        sem[1].v();


    }

}

class Thread_6 extends Thread{

    private Semaphore[] sem;

    public Thread_6(Semaphore[] sem, String name)
    {
        super(name);
        this.sem = sem;
        start();
    }

    private void A1()
    {
        System.out.println("Activity_4 running");
    }

    public void run()
    {
        A1();
        sem[0].v();
        sem[1].v();


    }

}

class Thread_7 extends Thread{

    private Semaphore[] sem;

    public Thread_7(Semaphore[] sem, String name)
    {
        super(name);
        this.sem = sem;
        start();
    }

    private void A1()
    {
        System.out.println("Activity_4 running");
    }

    public void run()
    {
        A1();
        sem[0].v();
        sem[1].v();


    }

}

