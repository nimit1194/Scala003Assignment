import org.scalatest.FunSuite

class ConvertToUpperCaseTest extends FunSuite {

  val convertToUpperCaseObj = new ConvertToUpper

  test("Testing upperCase for all extensions")
  {
    assert(convertToUpperCaseObj.upperCase("src/test/testFile/ConvertToUpperTest", "src/test/TestOutput/ConvertOutput/", "all"))
  }

  test("Testing upperCase for selected extensions")
  {
    assert(convertToUpperCaseObj.upperCase("src/test/testFile/ConvertToUpperTest", "src/test/TestOutput/ConvertOutput/", ".txt"))
  }

  test("Testing upperCase for invalid extension")
  {
    intercept[NullPointerException]
      {
        assert(convertToUpperCaseObj.upperCase("src/testdgfd/testFile", "src/test/ModifiedOutput/", ".invalid"))

      }
  }
}
