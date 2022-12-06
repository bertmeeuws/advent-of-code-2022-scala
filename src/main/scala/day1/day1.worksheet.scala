package day1

import scala.io.Source

object Main {
  case class Elf(id: Int, totalCalories: Int)

  val input = Source.fromFile("input.txt").getLines.mkString("\n")

  val elvesTotalCaloriesList = input.split("\n\n").toList.zipWithIndex.map {
    case (element, elf) =>
      val total = element.split("\n").toList.map(_.trim.toInt).sum
      Elf(elf+1,total)
  }

  def getElfWithMostCalories(list: List[Elf]) = {
    list.maxBy(_.totalCalories)
  }

  val elfThatEatsTooMuch = getElfWithMostCalories(elvesTotalCaloriesList)

  println(elfThatEatsTooMuch)

  def main(args:Array[String]) = {

  }
}