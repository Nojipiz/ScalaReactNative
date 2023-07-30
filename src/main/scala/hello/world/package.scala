package hello

import scala.scalajs.js.Dynamic.literal

package object world {

  val centerStyle = literal(
    flex = 1,
    justifyContent = "center",
    alignItems = "center"
  )

  object styles {

    val bigBlue = literal(
      color = "blue",
      fontWeight = "bold",
      fontSize = 30
    )

    val red = literal(
      color = "red"
    )

  }

  /** previously style was defined using this `styles2` approach underneath
   * then it felt that - what an object isTo itsVal isSameAs what Map isTo itsBinding
   * the api differs though. In former case - it's `styles.red`
   * In latter case - it's styles2("red")
   * former is typesafe, latter is not */
  val styles2 = Map(
    "bigBlue" -> literal(
      color = "blue",
      fontWeight = "bold",
      fontSize = 30
    ),
    "red" -> literal(
      color = "red"
    )
  )

}
