package br.ufc.quixada.sd;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BroadcastServer {
	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			socket = new DatagramSocket(5555, InetAddress.getByName("0.0.0.0"));
			socket.setBroadcast(true);
			while (true) {
				byte[] receiveArray = new byte[1000];
				DatagramPacket receivePacket = new DatagramPacket(receiveArray, receiveArray.length);
				socket.receive(receivePacket);
				String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
				//System.out.println("Mensagem recebida:" + msg);
				if(msg.equals("calc")){
					//new Calculadora();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket != null)
				socket.close();
		}
	}
}
