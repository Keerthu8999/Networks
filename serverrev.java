import java.io.*;
import java.util.*;
import java.net.*;
public class serverrev{
	public static void main(String[]args) throws IOException{
		ServerSocket ss=new ServerSocket(4444);
		Socket s=ss.accept();
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		String inp=dis.readUTF();
		StringBuilder ans=new StringBuilder();
		ans.append(inp);
		ans.reverse();
		dos.writeUTF(ans.toString());
	}
}
