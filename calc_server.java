import java.io.*;
import java.util.*;
import java.net.*;
public class calc_server
{
public static void main(String[] args) throws Exception
{
ServerSocket ss = new ServerSocket(4444);
Socket s = ss.accept();
DataOutputStream dos = new DataOutputStream(s.getOutputStream());
DataInputStream dis = new DataInputStream(s.getInputStream());
while(true)
{
String input = dis.readUTF();
if(input.equals("Bye"))
break;
System.out.println(input);
int result = 0;
StringTokenizer st = new StringTokenizer(input);
int op1 = Integer.parseInt(st.nextToken());
String opn = st.nextToken();
int op2 = Integer.parseInt(st.nextToken());
if(opn.equals("+"))
{
result = op1 + op2;
}
else if(opn.equals("-"))
{
result = op1 - op2;
}

else if(opn.equals("*"))
{
result = op1 * op2;
}
 
else if(opn.equals("/"))
{
result = op1 / op2;
}
dos.writeUTF(Integer.toString(result));
}}}
