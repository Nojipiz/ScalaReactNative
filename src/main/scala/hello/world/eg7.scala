package hello.world

import slinky.core._
import slinky.native._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement

@react class AlertButton extends StatelessComponent {
  type Props = Unit

  def render(): ReactElement = {
    View(
      style = centerStyle
    )(
      Button(
        title   = "Alert Me",
        onPress = () => Alert.alert("You are alerted!")
      )
    )
  }
}

object eg7 {
  def a() = AlertButton
}
