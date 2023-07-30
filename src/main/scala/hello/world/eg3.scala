package hello.world

import slinky.core._
import slinky.native._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement

import scala.scalajs.js.Dynamic.literal

import scala.scalajs.js.timers.setInterval

@react class Blink extends Component {
  type Props = String
  type State = Boolean

  def initialState: Boolean = true

  override def componentDidMount(): Unit = {
    setInterval(1000)(setState(ps => !ps))
  }

  def render(): ReactElement = {
    if(state) {
      View(
        style = literal(
          alignItems = "center"
        )
      )(
        Text(props)
      )
    } else {
      null
    }
  }

  def render2(): ReactElement = {
    View(
      style = literal(
        alignItems = "center"
      )
    )(
      if(state) Text(props) else Text("blank")
    )
  }

  def render3(): ReactElement = {
    View(
      style = literal(
        alignItems = "center"
      )
    )(
      Text(
        if(state) props else "blank2"
      )
    )
  }

}

@react class BlinkApp extends Component {
  type Props = Unit
  type State = Unit
  def initialState: State = ()

  def render(): ReactElement =
    View(
      style = centerStyle
    )(
      Blink("Text"),
      Blink("To"),
      Blink("Blink")
    )
}

object eg3 {
  def apply() = BlinkApp
}
