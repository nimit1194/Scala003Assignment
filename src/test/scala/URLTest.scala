import java.io.{File, FileNotFoundException}
import org.scalatest.FunSuite



class SplitURLTest extends FunSuite {

  val splitURLObj = new URL
  val RWObj = new FolderIO

  test("Testing splitFile with invalid input path")
  {
    intercept[FileNotFoundException]
      {
        splitURLObj.splitFile("/not-found-error", "src/test/SplitURLOutput")
      }
  }

  test("Testing splitFile with invalid output path")
  {
    intercept[FileNotFoundException] {
      splitURLObj.splitFile("src/test/testFiles/URLs.txt", "not-found-error")
    }
  }

  test("Testing splitFile with collection of different URLs")
  {
    assert(splitURLObj.splitFile("src/test/testFile/URLtest.txt", "src/test/SplitURLOutput"))
  }

}
