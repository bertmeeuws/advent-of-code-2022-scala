package day1

import scala.io.Source

object Main {
  val input = Source.fromFile("input.txt").getLines.mkString("\n")

  def createAbsoluteList(list: String) = {
    val Array(min, max) = list.split("-")
    (min.toInt to max.toInt)
  }

  val usableFormat = {
    val result = input.split("\n").toList.map(_.split(",").toList.grouped(3).map{ x =>
      val part1 = createAbsoluteList(x(0))
      val part2 = x(1)
      println(part1)
      println(part2)
      x
    })

    result.flatten

  }
  //println(usableFormat)

  def main(args:Array[String]) = {

  }
}