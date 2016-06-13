import java.net.*;
import java.io.*;
import java.util.*;

class Server{
	public static void main(String args[]) throws Exception{
		Scanner in=new Scanner(System.in);
		ServerSocket ServSoc=new ServerSocket(8000);			//Server waiting for a connection to be made
		Socket s=ServSoc.accept();					//To establish a connection
		DataInputStream Din=new DataInputStream(s.getInputStream());
		DataOutputStream Dout=new DataOutputStream(s.getOutputStream());
		String str="";
		String str2="";
		while(!str.equals("end")){
			str=Din.readUTF();
			System.out.println("Client says: "+str);
			str2=in.readLine();
			Dout.writeUTF(str2);
			Dout.flush();	
		}
		Din.close();
		s.close();
		ServSoc.close();
	}
}
