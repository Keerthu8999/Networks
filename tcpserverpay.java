import java.io.*;
import java.util.*;
import java.net.*;
public class tcpserverpay{
	public static void main(String[]args) throws IOException{
		ServerSocket ss=new ServerSocket(2345);
		Socket s=ss.accept();
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		String inp=dis.readUTF();
		StringTokenizer st=new StringTokenizer(inp);
		int days=Integer.parseInt(st.nextToken());
		int result=days*3000;
		dos.writeUTF(Integer.toString(result));
	}
}
