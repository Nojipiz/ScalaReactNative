package hello.world

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.native._
import scala.scalajs.js.Dynamic.literal

@react class PizzaTranslator extends Component {
  type Props = Unit
  case class State(inputText:String)
  def initialState: State = State("")

  def render(): ReactElement = {
    View(
      style = centerStyle
    )(
      TextInput(
        placeholder = "Type here to translate!",
        onChangeText = { text:String => setState(State(text)) }
        /** onChangeText replaces the current State with a new State instance
         * #doubt what happens to the old State object `State("")`? Is it marked for GC? Where was it allocated? Where is it now?*/
      ),
      Text("Translation"),
      Text {
        if(state.inputText.length != 0) {
          state.inputText.split(" ").map(w => "🍕").mkString(" ")
          /** #doubt what garbage does this↑ computation create? */
        }
        else "--"
      }
    )
  }
}

/** problems -  */

object eg6 {
  def apply() = PizzaTranslator 
}
