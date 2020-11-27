import java.io._

/**
 * ~/Code/scala-demo/script/ch31(main ✗) javap Reader
 * Compiled from "Reader.scala"
 * public class Reader {
 *   public int read() throws java.io.IOException;
 *   public Reader(java.lang.String);
 * }
 */
class Reader(fileName: String) {
  private val in = new BufferedReader(new FileReader(fileName))

  @throws(classOf[IOException])
  def read() = in.read()
}
