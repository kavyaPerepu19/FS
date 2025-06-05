// import java.util.*;
public class Account {
    int acc;
    String name;
    double balance;

    Account(int acc,String name,double balance)
    {
        this.acc = acc;
        this.name = name;
        this.balance = balance;
    }
    
    @Override
    public  boolean equals(Object o)
    {
        if((o instanceof Account )&&( ((Account)o).name.equals(this.name)) && ((Account)o).balance==(this.balance)){
            return true;
        }   
        return false;
    }

    public static void main(String args[])
    {
        Account a1 = new Account(1,"john",1000.0);
        Account a2 = new Account(1,"john",1000.0);

        Account a3 = new Account(1,"jane",1000.0);

        System.out.println(a1.equals(a2));
        System.out.println(a1.equals(a3));
        // int a[] = new int[]{10,20};
    }
}
