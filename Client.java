import java.net.*;
import java.io.*;
import java.util.*;

public class Client{
	public static void main(String args[]) throws Exception{
		Scanner in=new Scanner(System.in);
		Socket s=new Socket("localhost",8000);
		DataInputStream Din=new DataInputStream(s.getInputStream());
		DataOutputStream Dout=new DataOutputStream(s.getOutputStream());
		
		String str="";
		String str2="";
		System.out.println("Connection established. You can now chat with the server. Type 'end' when you wish to end the chat.");
		while(!str.equals("end")){
			str=in.nextLine();
			Dout.writeUTF(str);
			Dout.flush();
			str2=Din.readUTF();
			System.out.println("Server says: "+str2);
		}
	Dout.close();
	s.close();
	}
}
