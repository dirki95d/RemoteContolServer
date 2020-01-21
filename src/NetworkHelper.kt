import java.net.DatagramSocket
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Socket

object NetworkHelper {
    fun determineIpAdress(): String? {

        return if(System.getProperty("os.name").contains("Mac")){
            determineIpForMac()
        }
        else{
            determineIpForAllOtherSystems()
        }
    }

    private fun determineIpForAllOtherSystems(): String? {
        DatagramSocket().use { socket ->
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002)
            return socket.localAddress.hostAddress
        }
    }

    private fun determineIpForMac(): String? {
        // https://stackoverflow.com/questions/9481865/getting-the-ip-address-of-the-current-machine-using-java
        val socket = Socket()
        socket.connect(InetSocketAddress("google.com", 80))
        return socket.localAddress.hostAddress
    }
}