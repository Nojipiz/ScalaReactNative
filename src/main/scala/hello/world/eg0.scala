package hello.world

import slinky.core.annotations.react // @react annotation
import slinky.core._ // `Component`
import slinky.native._  // `View` & `Text` from react-native
import scala.scalajs.js.Dynamic.literal
import slinky.core.facade.ReactElement

/** HW0 component renders as a "Hello World" message
 * at the center of the screen */
@react class HW0 extends Component {

  type Props = Unit
  type State = String
  def initialState: State = "Hello World!"

  def render(): ReactElement =
    View(
      style = literal(
        flex = 1,
        justifyContent = "center",
        alignItems = "center"
      )
    )(
      Text(initialState)
    )

}
object eg0 {
  def apply() = HW0
}

/* equivalent react-native jsx
import React, { Component } from 'react';
import { Text, View } from 'react-native';

export default class HelloWorldApp extends Component {
  render() {
    return (
      <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
        <Text>Hello, world!</Text>
      </View>
    );
  }
}
*/