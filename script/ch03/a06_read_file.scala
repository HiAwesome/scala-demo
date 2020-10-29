import scala.io.Source

/**
 * 从文件读取文本行
 *
 * @author moqi On 10/29/20 15:37
 */
if (args.length > 0) {
  for (line <- Source.fromFile(args(0)).getLines()) {
    println(line.length + " " + line)
  }
} else {
  Console.err.println("Please enter filename.")
}
