organization := "fr.janalyse"
name         := "zio-test-tests"
homepage     := Some(new URL("https://github.com/dacr/zio-test-tests"))

licenses += "Apache 2" -> url(s"https://www.apache.org/licenses/LICENSE-2.0.txt")

scmInfo := Some(
  ScmInfo(
    url(s"https://github.com/dacr/zio-test-tests.git"),
    s"git@github.com:dacr/zio-test-tests.git"
  )
)

scalaVersion := "3.2.0"

lazy val versions = new {
  val zio = "2.0.2"
}

libraryDependencies ++= Seq(
  "dev.zio"       %% "zio"                 % versions.zio,
  "dev.zio"       %% "zio-test"            % versions.zio % Test,
  "dev.zio"       %% "zio-test-junit"      % versions.zio % Test,
  "dev.zio"       %% "zio-test-sbt"        % versions.zio % Test,
  "dev.zio"       %% "zio-test-scalacheck" % versions.zio % Test,
  //"com.github.sbt" % "junit-interface"     % "0.13.2"     % Test
)

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
//testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")

