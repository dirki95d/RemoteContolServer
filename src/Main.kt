import NetworkHelper.resolveIpAdress
import java.net.DatagramSocket
import java.net.InetAddress


class Main {
     companion object {
         @JvmStatic
         fun main(args: Array<String>) {
             val inetAddress = resolveIpAdress()
             println("Simple Remote Control Server is running on ${inetAddress}:8080")

             Server().startServer()
         }
     }
}