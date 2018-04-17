import java.util.concurrent.Semaphore;


public class Aufgabe1 {



    public static void main(String[] args){

    Semaphore [] sem = new Semaphore[9];

        for (int i = 0; i <sem.length ; i++) {
        sem[i] = new Semaphore(0);
        }

        new Thread_5(sem,"Thread_5");
        new Thread_6(sem,"Thread_6");
        new Thread_7(sem,"Thread_7");
        new Thread_1(sem,"Thread_1");
        new Thread_2(sem,"Thread_2");
        new Thread_3(sem,"Thread_3");
        new Thread_4(sem,"Thread_4");

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
        System.out.println("Activity_1 running");
    }

    public void run()
    {
        A1();
        sem[0].release();
        sem[1].release();
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

    private void A2()
    {
        System.out.println("Activity_2 running");
    }

    public void run()
    {
        try {
            sem[0].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A2();
        sem[2].release();
        sem[3].release();

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

    private void A3()
    {
        System.out.println("Activity_3 running");
    }

    public void run()
    {
        try {
            sem[1].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A3();
        sem[4].release();
        sem[5].release();

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

    private void A4()
    {
        System.out.println("Activity_4 running");
    }

    public void run()
    {
        try {
            sem[2].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A4();
        sem[6].release();
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

    private void A5()
    {
        System.out.println("Activity_5 running");
    }

    public void run()
    {
        try {
            sem[3].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sem[4].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A5();
        sem[7].release();
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

    private void A6()
    {
        System.out.println("Activity_6 running");
    }

    public void run()
    {
        try {
            sem[5].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A6();
        sem[8].release();
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

    private void A7()
    {
        System.out.println("Activity_7 running");
    }

    public void run()
    {
        try {
            sem[6].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sem[7].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sem[8].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A7();

    }

}

