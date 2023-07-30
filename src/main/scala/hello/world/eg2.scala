package hello.world

import slinky.core.annotations.react
import slinky.core._
import slinky.native._
import slinky.core.facade.ReactElement

import scala.scalajs.js.Dynamic.literal

/** canonical counter app
 * a button to increment counter
 * and a counter display
 * .
 * there's an incoming user triggered event
 * and completion of its propagation
 * results in the user seeing the updated counter */
@react class Counter extends Component {
  type Props = Unit
  type State = Int
  def initialState = 0

  def render(): ReactElement = {
    View(
      style = literal(
        flex = 1,
        justifyContent = "center",
        alignItems = "center"
      )
    )(
      Text("Count: " + state), /** `state` comes from extending `Component` */
      Button(title = "Tap Me!", onPress = () => {
        setState(_ + 1) /** here `setState` reference, is on the current component itself, ie, this/self */
      }),
      Button(title = "Reset", onPress = () => {
        setState(0)
      })
    )
  }
}

object eg2 {
  def apply() = Counter
}
