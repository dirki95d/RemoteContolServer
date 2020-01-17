import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket

class Server {
    private val server = ServerSocket(8080)
    private val keyCommander = KeyCommander()

    fun startServer(){
        while(true){
            val socket = server.accept()
            val message = readFromSocket(socket)
            print(message)
            interpretMessage(message.clear())
        }
    }

    private fun interpretMessage(message: String) {
        when(message){
             "rewind" -> keyCommander.leftArrow()
             "forward" -> keyCommander.rightArrow()
             "play" -> keyCommander.space()
        }

    }

    @Throws(IOException::class)
    fun readFromSocket(socket: Socket): String {
        val bufferedReader = BufferedReader(
                InputStreamReader(
                        socket.getInputStream()))
        val buffer = CharArray(200  )
        val charCount = bufferedReader.read(buffer, 0, 200)
        return String(buffer, 0, charCount)
    }

    private fun CharSequence.clear() = replace(Regex("\\n"), "");
}