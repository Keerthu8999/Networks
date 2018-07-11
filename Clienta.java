import java.io.*;
import java.util.*;
import java.net.*;
public class Clienta
{
private Socket socket = null;
private Scanner ab = null;
private DataInputStream input = null;
private DataOutputStream out = null;
public Clienta(String address,int port)
{
try
{
socket =  new Socket(address,port);
System.out.println("Connected");
ab = new Scanner(System.in);
out = new DataOutputStream(socket.getOutputStream());
}
catch(UnknownHostException u)
{System.out.println(u);}
catch(IOException i)
{System.out.println(i);}
String line = "";
while(!line.equals("Over"))
{
try
{
line = ab.next();
out.writeUTF(line);
}
catch(IOException i)
{
System.out.println(i);
}}
try
{
input.close();
out.close();
socket.close();
}
catch(IOException i)
{
System.out.println(i);
}
}
public static void main(String[] args)
{
Clienta clienta = new Clienta("127.0.0.1",5000);
}}

