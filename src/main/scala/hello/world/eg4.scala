package hello.world

import slinky.core.annotations.react
import slinky.core._
import slinky.core.facade.ReactElement
import slinky.native._

import scala.scalajs.js

/** https://facebook.github.io/react-native/docs/style */
@react class StyleDemo extends Component {
  type Props = Unit
  type State = Unit

  override def initialState: Unit = ()

  def render(): ReactElement = {
    View(

      Text(
        style = styles.red
      )("just red"),

      Text(
        style = styles.bigBlue
      )("just bigBlue"),

      /** You can also pass an array of styles - the last style in the array has precedence, so you can use this to inherit styles. */
      Text(
        style = js.Array(styles.bigBlue, styles.red)
      )("bigBlue, then red"),

      Text(
        style = js.Array(styles.red, styles.bigBlue)
      )("red, then bigBlue")

    )
  }

}

object eg4 {
  def apply() = StyleDemo
}
