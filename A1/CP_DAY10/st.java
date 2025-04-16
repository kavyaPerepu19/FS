// package A1.CP_DAY10;

class parent {
    static void fun()
    {
        System.out.println("hello from parent");
    }

    
}

class child extends parent{
     
    static void fun()
    {
        System.out.println("hello from child");
    }

}

public class st {

    public static void main(String[] args) {
        child c = new child();
        c.fun();

    }
}
