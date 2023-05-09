
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
    
    private DatagramSocket socket;
    
    public UDPClient() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException ex) {
            Main.addText("[-] Failed to create DatagramSocket");
        }
    }
    
    public void sendMessage(String message, String address, int port) {
        try {
            InetAddress addr = InetAddress.getByName(address);
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, addr, port);
            socket.send(packet);
        } catch (IOException ex) {
            Main.addText("[-] Failed to send msg to Server");
        }
    }
    
    public String receiveMessage() {
        try {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.setSoTimeout(2000); // Set a timeout of 2 seconds
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            return message;
        } catch (IOException ex) {
            Main.addText("[-] Failed to receive msg from Server");
        }
        return null;
    }
    
    public void close() {
        socket.close();
    }
}