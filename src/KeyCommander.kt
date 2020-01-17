import java.awt.Robot
import java.awt.event.KeyEvent

class KeyCommander {
    val robot = Robot()

    fun leftArrow(){
        simulateKeyPress(KeyEvent.VK_LEFT)
    }

    fun rightArrow(){
        simulateKeyPress(KeyEvent.VK_RIGHT)
    }

    fun space(){
        println("press space")
        simulateKeyPress(KeyEvent.VK_SPACE)
    }

    private fun simulateKeyPress(vkSpace: Int) {
        robot.keyPress(vkSpace)
        robot.keyRelease(vkSpace)
    }
}