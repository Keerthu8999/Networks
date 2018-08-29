import java.io.*;
import java.util.*;
import java.net.*;
public class tcpclientpay{
	public static void main(String[]args) throws IOException{
		InetAddress ip=InetAddress.getLocalHost();
		int port=2345;
		Scanner sc=new Scanner(System.in);
		Socket s=new Socket(ip,port);
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		System.out.println("Enter working days:");
		String inp=sc.nextLine();
		dos.writeUTF(inp);
		String ans=dis.readUTF();
		System.out.println(ans);
	}
}
