name := """RENTEASY"""

version := "0.7.4-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaCore, javaJdbc, javaEbean, javaWs,
   filters,
  "play2-crud" %% "play2-crud" % "0.7.4-SNAPSHOT",
  "play2-crud" %% "play2-crud" % "0.7.4-SNAPSHOT" classifier "assets",
  "mysql" % "mysql-connector-java" % "5.1.18",
  "commons-io" % "commons-io" % "2.3",
  "com.typesafe.play.plugins" %% "play-plugins-mailer" % "2.3.1",
  "org.apache.poi" % "poi-ooxml" % "3.9",
  "com.itextpdf" % "itextpdf" % "5.4.2",
  "com.itextpdf.tool" % "xmlworker" % "5.4.1",
  "com.typesafe.play" %% "play-ws" % "2.3.7",
  "org.json" % "org.json"% "chargebee-1.0",
  "org.apache.ibatis" % "ibatis-sqlmap" % "2.3.0",
  "com.edulify" %% "play-hikaricp" % "1.4.1",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)

resolvers += "release repository" at  "http://hakandilek.github.com/maven-repo/releases/"

resolvers += "snapshot repository" at "http://hakandilek.github.com/maven-repo/snapshots/"

resolvers += Resolver.url("Edulify Repository", url("http://edulify.github.io/modules/releases/"))(Resolver.ivyStylePatterns)