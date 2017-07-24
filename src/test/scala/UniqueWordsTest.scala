
import  org.scalatest.FunSuite


class UniqueWordsTest extends FunSuite {

  val uniqueWordsObj = new UniqueWords

  test("Testing uniqueWords with invalid path")
  {
    intercept[NullPointerException]
      {
        uniqueWordsObj.countUniqueWordsFileList("/home/not-found-error", "src/test/testOutput/CountTest/")
      }
  }

  test("Testing uniqueWords with valid path")
  {
    assert(uniqueWordsObj.countUniqueWordsFileList("src/test/testFile/CountWordTest/", "src/test/testOutput/CountTest/"))
  }

}
