name := "AkkaPractice"

version := "1.0"

scalaVersion := "2.11.8"

val akkaVersion = "2.4.17"

libraryDependencies ++= Seq(
  "org.seleniumhq.selenium" % "selenium-chrome-driver" % "3.0.1",
  "org.seleniumhq.selenium" % "selenium-java" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1"
)