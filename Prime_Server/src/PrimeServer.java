
import java.net.InetAddress;

public class PrimeServer extends UDPServer {

    public PrimeServer(int port) {
        super(port);
    }

    public boolean isInt(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isPrime(int n) {
        if (n <= 1) { // is 1 or smaller
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // received text, check if its a prime number and send him the result, 0 = not prime, 1 = prime 
    @Override
    public void handleMessage(String message, InetAddress address, int port) {
        if (message.length() > 100) {
            Main.addText("[-] Client: [" + address.getHostAddress() + "] tried to send a msg over 100 chars!");
            return;
        }

        if (!isInt(message)) {
            Main.addText("[-] Client: [" + address.getHostAddress() + "] tried to send a String instead of a Prime Number");
            return;
        }

        int number = Integer.parseInt(message);

        boolean isPrimeNum = isPrime(number);
        String msg = isPrimeNum ? "1" : "0";
        sendMessage(msg, address, port);
        Main.addText("[+] Sent To: [" + address.getHostAddress() + "] msg: ["+msg+"]");
    }

}
