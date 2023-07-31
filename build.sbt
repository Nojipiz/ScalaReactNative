import scala.sys.process.Process

externalNpm := {
  Process("npm", baseDirectory.value).!
  baseDirectory.value
}

lazy val root = project
.in(file("."))
.enablePlugins(ScalaJSPlugin, ScalablyTypedConverterExternalNpmPlugin)
.settings(
    name := "ScalaReactNative",
    version := "1.0",

    scalacOptions += "-Ymacro-annotations",
    scalaVersion := "2.13.11",

    stIgnore ++= List("css-type", "react-proxy"),
    stMinimize := Selection.All,
    stFlavour := Flavour.SlinkyNative,

    libraryDependencies += "me.shadaj" %%% "slinky-native" % "0.7.3",
    libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.7.3",
    libraryDependencies += "dev.zio" %%% "zio" % "2.0.15",
    libraryDependencies += "dev.zio" %%% "zio-logging" % "2.1.13",
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.5.0",
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time-tzdb" % "2.5.0",
    libraryDependencies += "org.scala-js" %%% "scala-js-macrotask-executor" % "1.1.1",

    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
)
