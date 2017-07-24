import java.io.FileNotFoundException
import java.io.File

class ReadWriteFromFolderTest extends org.scalatest.FunSuite {

  val fileobj = new FolderIO

  test("Testing read function with non-existing file")
  {
    intercept[FileNotFoundException] {
      val file = new File("noFile.txt")
      fileobj.read(file)
    }
  }

  test("Testing read function with existing file")
  {
    val file = new File("src/test/testFile/FolderIOTest/test.txt")
    assert(fileobj.read(file) == "testing read function file")
  }

  test("Testing write function with invalid directory path")
  {
    val file = new File("testWrite.txt")
    intercept[FileNotFoundException] {
      fileobj.write(file, "content", "/home/not-found-error")
    }
  }

  test("Testing write function with valid directory path")
  {
    val file = new File("testWrite.txt")

    assert(fileobj.write(file, "writing content in the file", "src/test/testFile/FolderIOTest"))
  }
}
