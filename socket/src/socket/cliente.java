package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class cliente {
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream out = null;
	public cliente(String address,int port) {
		try {
			socket = new Socket(address, port);
			System.out.println("Conectado...!");
			input = new DataInputStream(System.in);
			out = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException u) {
			System.out.println(u);
		} catch (IOException i) {
			System.out.println(i);
		}
		String line="";
		while(!line.equals("S")) {
			try {
				line = input.readLine();
				out.writeUTF(line);
			} catch (IOException i) {
				System.out.println(i);
			}
		}
		try {
			input.close();
			out.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}
public static void main(String[] args) {
	cliente cliente = new cliente("127.0.0.1",5050);
}
}
