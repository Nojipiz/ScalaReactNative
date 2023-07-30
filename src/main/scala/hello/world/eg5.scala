package hello.world

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.native._

import scala.scalajs.js.Dynamic.literal

/** http://facebook.github.io/react-native/docs/height-and-width#fixed-dimensions */
@react class FixedDimensionsBasics extends StatelessComponent {
  type Props = Unit

  def render(): ReactElement = {
    View(
      /** All dimensions in React Native are unitless, and represent density-independent pixels.
       * Setting dimensions this way is common for components that should always render at exactly the same size,
       * regardless of screen dimensions. */
      View(style = literal(width = 50, height = 50, backgroundColor = "powderblue")),
      View(style = literal(width = 100, height = 100, backgroundColor = "skyblue")),
      View(style = literal(width = 150, height = 150, backgroundColor = "steelblue"))
    )
  }
}

/** http://facebook.github.io/react-native/docs/height-and-width#flex-dimensions */
@react class FlexDimensionsBasics extends StatelessComponent {
  type Props = Unit

  /** Use flex in a component's style to have the component expand and shrink dynamically based on available space. */
  def render(): ReactElement = {
    View(style = literal(flex = 1))(
      View(style = literal(flex = 1, backgroundColor = "powderblue")),
      View(style = literal(flex = 2, backgroundColor = "skyblue")),
      View(style = literal(flex = 3, backgroundColor = "steelblue"))
    )
  }
}

object eg5 {
  def a() = FixedDimensionsBasics
  def b() = FlexDimensionsBasics
}
