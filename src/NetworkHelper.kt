import java.net.DatagramSocket
import java.net.InetAddress

object NetworkHelper {
    fun resolveIpAdress(): String? {
        DatagramSocket().use { socket ->
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002)
            return socket.localAddress.hostAddress
        }
        /*
        https://stackoverflow.com/questions/9481865/getting-the-ip-address-of-the-current-machine-using-java
        on mac:
        Socket socket = new Socket();
         socket.connect(new InetSocketAddress("google.com", 80));
         System.out.println(socket.getLocalAddress());
         */
    }
}