import java.io.*; 
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage; 

class UDPClient_img 
{ 
	public static void main(String args[]) throws Exception 
	{ 

		BufferedImage bi = ImageIO.read(new File("/mnt/d/UDP/aang.jpg")); //replace given file location with your local directory

		DatagramSocket clientSocket = new DatagramSocket(); 

		InetAddress IPAddress = InetAddress.getByName("LocalHost"); 

		byte[] sendData = new byte[40000]; 
		byte[] receiveData = new byte[1024]; 

		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		ImageIO.write(bi,"jpg",baos);
		sendData = baos.toByteArray();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
		clientSocket.send(sendPacket); 

		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 

		clientSocket.receive(receivePacket); 

		String modifiedSentence = new String(receivePacket.getData()); 

		System.out.println("FROM SERVER CODE : " + modifiedSentence); 

		clientSocket.close(); 
	} 
}
