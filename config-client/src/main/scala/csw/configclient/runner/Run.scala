package csw.configclient.runner

import java.net.URLClassLoader

import org.scalatest.tools.Runner

object Run {
  def main(args: Array[String]): Unit = {

    val testJarsRunpath = getClass.getClassLoader
      .asInstanceOf[URLClassLoader]
      .getURLs
      .map(_.getPath)
      .find(x ⇒ x.contains("csw-config-client") && x.contains("tests.jar"))
      .getOrElse("")

    val params = Array("-o", "-l", "csw.commons.tags.FileSystemSensitive", "-R", testJarsRunpath)

    println("=" * 100)
    println(s"Running tests from jar: [$testJarsRunpath]")
    println("=" * 100)

    Runner.main(params)
  }
}