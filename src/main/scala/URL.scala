import java.io.File

object ExtractProtocol {

  def unapply(url: String): Option[(String,String)]= {

    val protocol = url.split("://").toList
    if(protocol.length == 1)  None else Some(protocol(0), protocol(1))
  }
}

object  ExtractHost {

  def unapply(url: String): Option[(String,String,Option[Map[String,String]])] = {

    val hostDomainPart = url.split("/")
    val hostDomain = hostDomainPart(0).split("\\.")
    if(hostDomain.length == 1) {
      None
    }
    else
    {
      val domain = hostDomain.reverse.takeWhile(_ != hostDomain(1)).reverse.mkString(".")

      val querryPar = if(hostDomainPart.length > 1)
      {
        if(hostDomainPart.last.contains("&"))
        {
          Some(hostDomainPart.last.split("\\?").toList.last.split("&").toList
            .map(_.split("=")).map(s => (s(0), s(1))).toMap)
        }
        else
        {
          None
        }
      }
      else
      {
        None
      }
      Some(hostDomain(1), domain,querryPar)
    }
  }
}



class URL extends FolderIO {

  def splitFile(filePath: String, destPath: String): Boolean = {
    val file = new File(filePath)
    val fileContent = read(file)
    val fileContentList = fileContent.split("\n").toList

    val splitResult = fileContentList.map{
      _ match {
        case ExtractProtocol(protocol,ExtractHost(host,domain,None)) => "Protocol -> " + protocol + "\n" +
          "Host -> " + host + "\n" +
          "Domain -> " + domain + "\n\n"

        case ExtractProtocol(protocol,ExtractHost(host,domain,Some(value))) => "Protocol -> " + protocol + "\n" +
          "Host -> " + host + "\n" +
          "Domain -> " + domain + "\n" +
          "Query Params -> " + value + "\n\n"

        case _ => "Invalid URL Address\n\n"
      }
    }

    write(file, splitResult.mkString, destPath)
  }

}