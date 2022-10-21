package test.scala.fr.janalyse.ziotests

import zio.test.*
import zio.test.TestAspect.*
import org.junit.runner.RunWith
import zio.test.junit.JUnitRunnableSpec

@RunWith(classOf[zio.test.junit.ZTestJUnitRunner])
class MainSpec extends ZIOSpecDefault {
//class MainSpec extends JUnitRunnableSpec {

  override def spec = junitRunnerMinimalSuite

  val junitRunnerMinimalSuite = // https://github.com/zio/zio/issues/7450
    suite("Z")(
      test("A")(assertTrue(true)),
      test("B")(assertTrue(true)) @@ ignore
    )

  val minimalSuite = // https://github.com/zio/zio/issues/7449
    suite("A")(
      test("A")(assertTrue(true)),
      test("B")(assertTrue(false))
    ) @@ timed

  val fullSuite = suite("a")(
    test("a-0")(assertTrue(true)),
    test("a-1")(assertTrue(true)),
    suite("a-b")(
      test("a-b-0")(assertTrue(true)),
      test("a-b-1")(assertTrue(true))
    ),
    test("a-2")(assertTrue(true)) @@ ignore,
    suite("a-c")(
      test("a-c-0")(assertTrue(true)),
      test("a-c-1")(assertTrue(false)),
      suite("a-c-a")(
        test("a-c-a-0")(assertTrue(true)),
        test("a-c-a-1")(assertTrue(true)) @@ ignore,
        test("a-c-a-2")(assertTrue(false))
      )
    ),
    test("a-3")(assertTrue(false))
  ) @@ timed
}

object MainSpec extends ZIOSpecDefault {
  override def spec = (new MainSpec).spec
}
