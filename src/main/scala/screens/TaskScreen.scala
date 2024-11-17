package screens

import slinky.core.annotations.react
import slinky.native._
import slinky.core._
import scala.scalajs.js.Dynamic.literal
import scala.scalajs.js.undefined
import scala.scalajs.js.timers._
import slinky.core.facade.ReactElement
import typings.reactRouterNative.components._
import _root_.screens.common.Styles
import slinky.core.facade.Hooks._

@react object TaskScreen {

  case class Props(
      val times: Int,
      val updateTimes: Option[(Int) => Unit]
  )

  def runTask(updateTimes: () => Unit) = {
    // updateTimes()
  }

  val component = FunctionalComponent[Props] { props =>
    val (isLoading, setIsLoading) = useState(false)

    View(style = Styles.centerContent)(
      Text(style =
        literal(
          fontSize = 15,
          fontWeight = "bold"
        )
      )(s"Task Status")
    )
  }
}
