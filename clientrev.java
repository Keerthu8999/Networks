import java.io.*;
import java.util.*;
import java.net.*;
public class clientrev{
	public static void main(String[]args) throws IOException{
		InetAddress ip=InetAddress.getLocalHost();
		int port=4444;
		Scanner sc=new Scanner(System.in);
		Socket s=new Socket(ip,port);
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		String inp=sc.next();
		dos.writeUTF(inp);
		String a=dis.readUTF();
		System.out.println(a);
	}
}
