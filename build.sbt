name := "SmartConstructors"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "com.sksamuel.avro4s" %% "avro4s-core" % "1.8.1",
  "org.typelevel" %% "cats-core" % "1.0.1",
  "org.scalameta" %% "scalameta" % "3.2.0"
)

val circeVersion = "0.9.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

scalacOptions ++= Seq(
  "-Ypartial-unification",
  "-Xplugin-require:macroparadise"
)

addCompilerPlugin("org.scalameta" % "paradise" % "3.0.0-M11" cross CrossVersion.full)

// macroparadise plugin doesn't work in repl yet.
scalacOptions in (Compile, console) ~= (_ filterNot (_ contains "paradise"))