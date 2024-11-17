package navigation

import slinky.core._
import slinky.core.facade.ReactElement
import slinky.core.facade.Hooks._
import slinky.core.annotations.react
import slinky.native._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal
import typings.reactRouterNative.components.{Route, Link, NativeRouter, Routes}
import screens.TaskScreen
import screens.common._

@react object AppNavigator {
  type Props = Unit
  case class State(val amountTimes: Int)

  val component = FunctionalComponent[Props] { props =>

    NativeRouter(
      View(style =
        literal(
          marginTop = 25,
          padding = 10,
          flex = 1
        )
      )(
        View(
          style = literal(
            flexDirection = "row",
            justifyContent = "space-around"
          )
        )(
          NavigationButton(
            title = "Task",
            route = "/task"
          ),
          NavigationButton(title = "Home", route = "/"),
          NavigationButton(title = "Requests", route = "/requests")
        ),
        Routes(
          Route
            .IndexRouteProps()
            .path("/")
            .element(Text("Homee")),
          Route
            .PathRouteProps()
            .path("/task")
            .element(Text("Task")),
          Route
            .PathRouteProps()
            .path("/requests")
            .element(Text("Request"))
        )
      )
    )
  }
}
