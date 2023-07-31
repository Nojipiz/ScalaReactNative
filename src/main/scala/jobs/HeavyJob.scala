package jobs

import zio._
import scala.concurrent.Future

object HeavyJob{

  import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits._
  def run( update: (Int) => Unit ): Future[Unit] = Future {
    Unsafe.unsafe { implicit unsafe =>
      Runtime.default.unsafe.run(HeavyJob.runTask(update = update)).getOrThrowFiberFailure()
    }
  }

  private def runTask( update: (Int) => Unit ) = for{
    _ <- ZIO.logInfo("Hello from ZIO!")
    data <- Random.nextInt
  } yield (update(data))
}
