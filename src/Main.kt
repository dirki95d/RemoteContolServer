import NetworkHelper.determineIpAdress


class Main {
     companion object {
         @JvmStatic
         fun main(args: Array<String>) {
             val inetAddress = determineIpAdress()
             println("Simple Remote Control Server is running on $inetAddress:8080")

             Server().startServer()
         }
     }
}