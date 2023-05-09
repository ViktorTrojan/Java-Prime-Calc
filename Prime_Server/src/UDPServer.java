
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    
    private DatagramSocket socket;
    private boolean running;
    private byte[] buffer = new byte[1024];
    
    public UDPServer(int port) {
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException ex) {
            Main.addText("[-] Failed to create DatagramSocket");
        }
    }
    
    public void start() {
        running = true;
        while (running) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                handleMessage(message, packet.getAddress(), packet.getPort());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
    
    public void stop() {
        running = false;
    }
    
    public void handleMessage(String message, InetAddress address, int port) {
        // Override this method to handle incoming messages
    }
    
    public void sendMessage(String message, InetAddress address, int port) {
        try {
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            socket.send(packet);
        } catch (IOException ex) {
            Main.addText("[-] Failed to send msg to: [" + address.getHostAddress() + "]");
        }
    }
}