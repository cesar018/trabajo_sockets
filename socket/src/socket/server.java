package socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	private Socket socket=null;
	private ServerSocket server=null;
	private DataInputStream in=null;
	public server(int port) throws IOException{
		server= new ServerSocket(port);
		System.out.println("Server iniciado...!");
		socket = server.accept();
		System.out.println("Cliente aceptado");
		in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		String line="";
		while(!line.equals("S")) {
			try {
				line = in.readUTF();
				System.out.println(line);
			} catch (IOException i) {
				System.out.println(i);
			}
		}
		System.out.println("Cerrando la conexión");
		socket.close();
		in.close();
	}
public static void main(String[] args) throws IOException {
	server server = new server(5050);
}
}
