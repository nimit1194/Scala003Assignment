import java.io.File

trait ReaderAndWriter {

  def read(f:File): String

  def write(file: File, content: String, dirPath: String): Boolean
}
