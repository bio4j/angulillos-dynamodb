Nice.javaProject

javaVersion := "1.8"

name := "angulillos-dynamodb"

description := "angulillos-dynamodb project"

organization := "bio4j"

bucketSuffix := "era7.com"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-java-sdk" % "1.9.16",
  "bio4j" % "angulillos" % "0.4.1"
)

dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-core" % "2.3.2",
  "com.fasterxml.jackson.core"%"jackson-databind" % "2.3.2",
  "commons-logging" % "commons-logging" % "1.1.3"
)
