import java.net.*;
import java.io.*;

public class textfile_server
{
	public static void main(String args[])throws IOException
    {
        long start = System.currentTimeMillis();
        byte b[]=new byte[3072];
        DatagramSocket dsoc=new DatagramSocket(5555);
        FileOutputStream f=new FileOutputStream("newtext.txt");

        DatagramPacket dp=new DatagramPacket(b,b.length);
        dsoc.receive(dp);
        System.out.println(new String(dp.getData(),0,dp.getLength()));                             
        f.write(b);
        f.close();

        long end = System.currentTimeMillis();
        System.out.println((end - start));
    }
}
