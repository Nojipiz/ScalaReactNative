package main

import scala.scalajs.js
import scala.scalajs.LinkingInfo
import scala.scalajs.js.annotation.{JSExportTopLevel, JSImport}

import zio._
import slinky.native.AppRegistry
import slinky.hot
import java.time._
import navigation.AppNavigator
import slinky.core.annotations.react
import slinky.core.StatelessComponent
import slinky.core.facade.ReactElement

object Main {
  if (LinkingInfo.developmentMode) {
    hot.initialize()
  }

  @react class App extends StatelessComponent{
    type Props = Unit
    def render(): ReactElement = AppNavigator()
  }

  @JSExportTopLevel("app")
  val app = App.componentConstructor
}

