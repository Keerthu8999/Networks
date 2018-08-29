import java.io.*;
import java.util.*;
import java.net.*;
public class Client throws Exception
{
private Socket socket = null;
private DataInputStream input = null;
private DataOutputStream out = null;
public Client(String address,int port)
{
try
{
Socket = new Socket(address,port);
System.out.println("Connected");
input = new DataInputStream(s.getInputStream());
out = new DataOutputStream(s.getOutputStream());
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
line = input.readLine();
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
Client cl = new Client("127.0.0.1",5000);
}}

