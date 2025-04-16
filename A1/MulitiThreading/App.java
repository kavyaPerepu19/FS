import java.util.*;
class Searching implements Runnable{
    public void run()
    {
        System.out.println("Searching");

    }
}

class Sorting implements Runnable{
    public void run()
    {
        System.out.println("Sorting");
    }
}
class App {
    public static void main(String[] args) {
        Thread searchThread = new Thread(new Searching());
        Thread sortThread = new Thread(new Sorting());

        searchThread.start();
        sortThread.start();

    }
}
