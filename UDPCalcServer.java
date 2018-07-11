import java.util.*;
import java.io.*;
import java.net.*;
public class UDPCalcServer
{
public static void main(String[] args) throws Exception
{
DatagramSocket ds = new DatagramSocket(1234);
DatagramPacket Dpreceive = null;
DatagramPacket Dpsend = null;
byte[] buf = null;
while(true)
{
buf = new byte[65535];
Dpreceive = new DatagramPacket(buf,buf.length);
ds.receive(Dpreceive);
String inp = new String(buf,0,buf.length);
inp = inp.trim();
System.out.println("Equation : "+inp);
if(inp.equals("Bye"))
{
System.out.println("Client Taattaaa");
break;
}
int result = 0;
StringTokenizer st = new StringTokenizer(inp);
int op1 = Integer.parseInt(st.nextToken());
String operation = st.nextToken();
int op2 = Integer.parseInt(st.nextToken());
if(operation.equals("+"))
{
result = op1 + op2;
}

else if (operation.equals("-"))
{
result = op1 - op2;
}

else if(operation.equals("*"))
{
result = op1 * op2;
}
else if(operation.equals("/"))
{
result = op1 / op2;
}
System.out.println("Sending...");
String res = Integer.toString(result);
buf = res.getBytes();
int port = Dpreceive.getPort();
Dpsend = new DatagramPacket  (buf,buf.length,InetAddress.getLocalHost(),port);
ds.send(Dpsend);
}
}}
