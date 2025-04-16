interface Greeting {

    void greet(String s);
    
}

public class Temp {
    
    public static void main(String[] args) {
        
        withOutLamba1 w1 = new withOutLamba1();
        w1.greet("name1");
        withOutLamba2 w2 = new withOutLamba2();
        w2.greet("name2");

        Greeting g1 = (String s)->{System.out.println("lambda hi "+s);};
        g1.greet("name3");
        
        System.out.println(g1);
    }

}

class withOutLamba1 implements Greeting{
    public void greet(String s)
    {
        System.out.println("hello "+s);
    }
}

class withOutLamba2 implements Greeting{
    public void greet(String s)
    {
        System.out.println("GM "+s);
    }
}