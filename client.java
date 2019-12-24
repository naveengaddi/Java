import java.io.*;
import java.util.*;
import java.net.*;
class Client{
	void connect(){
		try{
			Socket socks = new Socket("192.168.43.214",4242);
			System.out.println("Connected to >>");
			DataInputStream din = new DataInputStream(socks.getInputStream());
			String s = (String)din.readUTF();
			System.out.println("message from server"+s);
			/*InputStreamReader ip = new InputStreamReader(socks.getInputStream());
			BufferedReader br = new BufferedReader(ip);
			ystem.out.println(br.readLine());
			br.close();	*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Client cli = new Client();
		System.out.println("Started Connecting");
		cli.connect();
	}
}