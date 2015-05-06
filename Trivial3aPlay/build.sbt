name := """Trivial3aPlay"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.mongodb" % "mongo-java-driver" % "2.13.0",
  "org.jdom" % "jdom2" % "2.0.6",
  "com.google.code.gson" % "gson" % "2.3.1",
  "info.cukes" % "cucumber-java" % "1.1.3",
  "info.cukes" % "cucumber-junit" % "1.2.2",
  "info.cukes" % "cucumber-html" % "0.2.3"
)