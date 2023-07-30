package example
 
import zio._

object HelloZio {

  def run(args: List[String]) = program

  val program =
    for {
      _ <- ZIO.succeed("Lol")
      _ <- ZIO.succeed(Test.hola)
    } yield ()
}

object Test {
  val hola: String = ""
}
