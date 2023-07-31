package navigation

import slinky.core._
import slinky.core.facade.ReactElement
import slinky.core.facade.Hooks._
import slinky.core.annotations.react
import slinky.native._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal
import typings.reactRouterNative.components.{Route, Link, NativeRouter, Routes}
import screens.ZioScreen
import screens.common._

@react object AppNavigator {
  type Props = Unit
  case class State(val amountTimesZIO: Int)

  val component = FunctionalComponent[Props]{ props => 
    val (state, updateState) = useState(State(amountTimesZIO = 0))

    val updateTimesZIO = (number:Int) => {
      updateState(state.copy(amountTimesZIO = number))
    }

    NativeRouter(
      View(style = literal(
        marginTop = 25,
        padding = 10,
        flex = 1,
        ))(
          View(
            style = literal(
              flexDirection = "row",
              justifyContent = "space-around",
              )
            )(
              NavigationButton(
                title = "ZIO", 
                route =  "/zio", 
                notifications = Some(state.amountTimesZIO),
              ),
              NavigationButton(title = "Home", route =  "/"),
              NavigationButton(title = "Requests", route =  "/requests")
            ),
          Routes(
            Route.IndexRouteProps()
              .path("/")
              .element(Text("Home")),
              Route.PathRouteProps()
                .path("/zio")
                .element(
                  ZioScreen(
                    times = state.amountTimesZIO,
                    updateTimes = Some(updateTimesZIO)
                  )
                ),
              Route.PathRouteProps()
                .path("/requests")
                .element(Text("Request"))
              )
            )
          )
  }
}

