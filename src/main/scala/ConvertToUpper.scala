
import java.io.File

class ConvertToUpper extends FolderIO {


  def upperCase(sourcePath: String, destPath: String, extension: String): Boolean = {

    try {

      val ListOfFiles: List[File] = extension match {
        case "all" => new File(sourcePath).listFiles().toList

        case _ => {
          val fileList = new File(sourcePath).listFiles().filter(f => f.getName.endsWith(extension)).toList
          fileList
        }
      }

      val ContentOfFiles = ListOfFiles.map(read(_)).map(_.toUpperCase)

      val filesWrite = ListOfFiles.zip(ContentOfFiles)

      filesWrite.map(t => write(t._1, t._2, destPath))


      true
    }
    catch
    {
      case ex: java.io.FileNotFoundException => throw ex
    }


  }
}

