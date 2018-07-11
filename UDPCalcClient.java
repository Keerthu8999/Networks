import java.io.*;
import java.net.*;
import java.util.*;
public class UDPCalcClient
{
public static void main(String[] args)throws Exception
{
Scanner sc = new Scanner(System.in);
DatagramSocket ds = new DatagramSocket();
InetAddress ip = InetAddress.getLocalHost();
byte buf[] = null;
while(true)
{
System.out.println("Op1 opn Op2");
String inp = sc.nextLine();
buf = new byte[65535];
buf = inp.getBytes();
DatagramPacket DpSend = new DatagramPacket(buf,buf.length,ip,1234);
ds.send(DpSend);
if(inp.equals("bye"))
break;
buf = new byte[65535];
DatagramPacket dpRecieve = new DatagramPacket(buf,buf.length);
ds.receive(dpRecieve);
System.out.println("Ans: " + new String(buf , 0 , buf.length));
}}}
