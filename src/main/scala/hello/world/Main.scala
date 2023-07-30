package hello.world

import scala.scalajs.js
import scala.scalajs.LinkingInfo
import scala.scalajs.js.annotation.{JSExportTopLevel, JSImport}

import slinky.native.AppRegistry
import slinky.hot

object Main {
  if (LinkingInfo.developmentMode) {
    hot.initialize()
  }

  @JSExportTopLevel("app")
  val app = 
    eg6().componentConstructor
    // eg0().componentConstructor
    //App.componentConstructor
    //eg1().componentConstructor
    //eg2().componentConstructor
    //eg3().componentConstructor
    //eg4().componentConstructor
    //eg5.a().componentConstructor
    //eg5.b().componentConstructor
    // eg7.a().componentConstructor
    //
}
