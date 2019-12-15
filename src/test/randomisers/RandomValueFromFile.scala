package randomisers

import scala.io.Source
import scala.util.Random

object RandomValueFromFile {
  def apply(fileLocation : String): String = {
    val loadedFile = Source.fromFile(fileLocation)
    val content = loadedFile.getLines()
    val shuffled = Random.shuffle(content)
    loadedFile.close()
    shuffled.next()
  }
}
