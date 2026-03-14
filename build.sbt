ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.8.2"

lazy val root = (project in file("."))
  .settings(
    name := "DoublyLinkedListScala3"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test