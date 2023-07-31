package navigation

import slinky.core.annotations.react
import slinky.native._
import slinky.core._
import scala.scalajs.js.Dynamic.literal
import scala.scalajs.js.undefined
import slinky.core.facade.ReactElement
import typings.reactRouterNative.components._
import typings.reactRouterNative.mod.useNavigate

@react object NavigationButton {
  val touchableStyle = literal(
    color = "black",
    backgroundColor = "white",
  )
  val textStyle = literal(
    fontSize = 18,
    fontWeight ="bold",
  )

  case class Props(
    val title: String,
    val route: String,
    val notifications: Option[Int] = None,
  )

  val component = FunctionalComponent[Props] { props =>
    val navigation = useNavigate()

    View()(
      TouchableOpacity( 
        onPress = () => { 
          navigation(props.route) 
        },
        style = touchableStyle)(
          Text(style = textStyle)(props.title)
        )
      )
  }
}
