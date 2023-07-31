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
import jobs.HeavyJob

@react object ZioScreen{

  case class Props(
    val times:Int,
    val updateTimes: Option[(Int) => Unit]
  )

  def runTask(updateTimes:(Int) => Unit) = setTimeout(1){
    HeavyJob.run( update = updateTimes )
  }

  val component = FunctionalComponent[Props] { props =>
    val (isLoading, setIsLoading) = useState(false)

    View(style = Styles.centerContent)(
      Text(style = literal(
        fontSize = 15,
        fontWeight ="bold"
      )
    )(s"ZIO Status"),

    if(isLoading){
      Text("Loading ...")
    }
    else{
      Text(s"Random number: ${props.times}")
    },

    Button(
      onPress = () => { 
        setIsLoading(true)
        runTask(props.updateTimes.get)
        setIsLoading(false)
      },
      title = "Run!"
    )
    )
  }
}

