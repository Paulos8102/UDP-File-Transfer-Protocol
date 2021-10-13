import java.io.*; 
import java.net.*; 
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage; 

class UDPServer_img 
{ 
	public static void main(String args[]) throws Exception 
	{ 
 
	DatagramSocket serverSocket = new DatagramSocket(9876); 
 
	byte[] receiveData = new byte[40000]; 
	byte[] sendData = new byte[1024]; 
 
	while(true) 
		{ 
 
		DatagramPacket receivePacket = 	new DatagramPacket(receiveData, receiveData.length); 
 
		serverSocket.receive(receivePacket); 
 
		InputStream is = new ByteArrayInputStream(receiveData);
		BufferedImage bi = ImageIO.read(is);
		InetAddress IPAddress = receivePacket.getAddress(); 
		ImageIO.write(bi, "jpg",new File("/mnt/d/UDP/aang1.jpg")); //replace given file location with your local directory 
		int port = receivePacket.getPort(); 

		String capitalizedSentence = "Received from Client!"; 
		sendData = capitalizedSentence.getBytes(); 
 
		DatagramPacket sendPacket = 
		new DatagramPacket(sendData, sendData.length, IPAddress, port); 

		serverSocket.send(sendPacket); 
		} 
	}
}
