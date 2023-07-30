package hello.world

import slinky.core.annotations.react // @react annotation
import slinky.core._ // `Component`
import slinky.native._  // `View` & `Text` from react-native
import scala.scalajs.js.Dynamic.literal
import slinky.core.facade.ReactElement


/* equivalent react-native code
import React, { Component } from 'react';
import { Text, View } from 'react-native';

class Greeting extends Component {
  render() {
    return (
      <View style={{alignItems: 'center'}}>
        <Text>Hello {this.props.name}!</Text>
      </View>
    );
  }
}
*/
@react class Greeting extends Component {
  
  type Props = String
  type State = Unit
  def initialState: State = ()
  
  def render(): ReactElement =
    View(
      style = literal(
        alignItems = "center"
      )
    )(
      Text(s"Hello ${props}!")
    )

}

/* react-native code
export default class LotsOfGreetings extends Component {
  render() {
    return (
      <View style={{alignItems: 'center', top: 50}}>
        <Greeting name='Rexxar' />
        <Greeting name='Jaina' />
        <Greeting name='Valeera' />
      </View>
    );
  }
}
*/
@react class SomeGreetings extends Component {

  type Props = Unit
  type State = Unit
  def initialState: State = ()

  def render(): ReactElement =
    View(
      style = literal(
        alignItems = "center",
        top = 50
      )
    )(
      Greeting("Rexxar"),
      Greeting("Jaina"),
      Greeting("Valeera")
    )

}

object eg1 {
  def apply() = SomeGreetings
}
