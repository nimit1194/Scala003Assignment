import java.io.File


class UniqueWords extends FolderIO{

  def countUniqueWordsFileList(sourcePath: String, destPath: String): Boolean = {

    try {
      val ListOfFiles = new File(sourcePath).listFiles().toList

      ListOfFiles.map(countUniqueWordsFromFile(_, destPath))
      true
    }
    catch{

      case ex:Exception => throw ex
    }
  }

  private def countUniqueWordsFromFile(file: File, destPath: String):Boolean = {

    val ContentOfFile = read(file).toLowerCase

    val regexp = """[A-Za-z]+""".r

    val words = for {
      s <- regexp.findAllIn(ContentOfFile)
    } yield s

    val WordsList = words.toList
    val WordCountMap = WordsList.groupBy(identity).mapValues(_.size)

    write(file, WordCountMap.mkString("\n"), destPath)
    true


  }

}

