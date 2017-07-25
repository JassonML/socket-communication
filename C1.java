package com.test.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class C1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket socket = new Socket("localhost",996);
			System.out.println("已连接...");
			DataInputStream dio = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String msg = dio.readUTF();
			dos.writeUTF("这里是客户端发送的消息,do you copy?");
			dos.write("testBytes".getBytes());
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
