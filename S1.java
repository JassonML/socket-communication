package com.test.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class S1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new S1().createComm();
	}
	
	public void createComm() {
		
		try {
			//创建服务端socket，等待请求，端口号为996
			ServerSocket server = new ServerSocket(996);
			System.out.println("服务端socket开始监听...");
			while(true){
				Socket client = server.accept();
				System.out.println("连接已建立...");
				new server(client).start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public class server extends Thread{
		
		public Socket socket;
		DataInputStream dis;
		DataOutputStream dos;
		
		public server(Socket socket){
			this.socket = socket;
			try {
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}	
		
		public void run(){
			try {
				dos.writeUTF("这里是服务端,copy that!!");
				String msg = dis.readUTF();
				System.out.println(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}	
}
