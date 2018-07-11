import java.io.*;
import java.net.*;
import java.util.*;
public class calc_client
{
public static void main(String[] args) throws Exception
{
InetAddress ip = InetAddress.getLocalHost();
int port = 4444;
Scanner sc = new Scanner(System.in);
Socket s = new Socket(ip,port);
DataInputStream dis = new DataInputStream(s.getInputStream());
DataOutputStream dos = new DataOutputStream(s.getOutputStream());
while(true)
{
System.out.println("Equation : ");
String inp = sc.nextLine();
if(inp.equals("Bye"))
break;
dos.writeUTF(inp);
String ans = dis.readUTF();
System.out.println(ans);
}}}
