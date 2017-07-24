
import java.io.{File, PrintWriter}
import scala.io.Source.fromFile



class FolderIO extends ReaderAndWriter {

  override def read(f: File): String = {

    fromFile(f).getLines.mkString("\n")

  }

  override def write(file: File, content: String, dirPath: String): Boolean = {

    new File(dirPath).mkdir()
    val writeFile = new PrintWriter(dirPath + "/" + file.getName)

    try {
      writeFile.write(content)
      true
    }
    catch {
      case ex: Exception => false

    }
    finally {
      writeFile.close()

    }
  }
}

