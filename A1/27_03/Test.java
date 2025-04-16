interface I1{
    void read();
    // void delete();
}

class dataBaseRead implements I1{
    public void read()
    {
        System.out.println("read from db");
    }
    
}


class SocketRead implements I1{

    public void read()
    {
        System.out.println("read from socket");
    }
}

class FileRead implements I1{
    public void read()
    {
        System.out.println("read from File");
    }
}

public class Test{
    public static void main(String[] args) {
        dataBaseRead dbr = new dataBaseRead();
        dbr.read();

        SocketRead sr = new SocketRead();
        sr.read();

        FileRead fr = new FileRead();
        fr.read();
    }
}