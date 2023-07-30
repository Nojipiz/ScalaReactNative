import scala.sys.process.Process

externalNpm := {
  Process("npm", baseDirectory.value).!
  baseDirectory.value
}

lazy val root = project
.in(file("."))
.enablePlugins(ScalaJSPlugin, ScalablyTypedConverterExternalNpmPlugin)
.settings(
    name := "zarn",
    version := "1.0",

    scalacOptions += "-Ymacro-annotations",
    scalaVersion := "2.13.11",

    stIgnore ++= List("css-type", "react-proxy"),
    stMinimize := Selection.All,
    stFlavour := Flavour.SlinkyNative,


    libraryDependencies += "me.shadaj" %%% "slinky-native" % "0.7.3",
    libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.7.3",
    libraryDependencies += "dev.zio" %%% "zio" % "2.0.15",

    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
)
