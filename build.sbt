name := """integration"""
organization := "com.home"

version := "1.0-SNAPSHOT"

lazy val ITest = config("it") extend Test

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .configs(ITest)
  .settings(inConfig(ITest)(Defaults.testSettings): _ *)

javaSource in ITest:= baseDirectory.value / "/it"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  guice,
  "junit" % "junit" % "4.12" % ITest
)

