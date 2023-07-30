enablePlugins(ScalaJSPlugin)

name := "zarn"

scalaVersion := "2.13.11"
scalacOptions += "-Ymacro-annotations"

libraryDependencies += "me.shadaj" %%% "slinky-native" % "0.7.3"
libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.7.3"
//libraryDependencies += "dev.zio" %%% "zio" % "2.0.0"

scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
