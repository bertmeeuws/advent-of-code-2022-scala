import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.control.Breaks._

object Main {

  val input = Source.fromFile("input.txt").getLines.toList

  def splitStringInTwo(list: List[String])(grouped: List[List[String]] => Unit) = {
    val groupBy = list.map(k => k.grouped(k.length /2).toList)

    grouped(groupBy)
  }


  val badgesList = {
    val grouped = input.grouped(3).toList.flatMap(x => {
      val part1 = x(0).split("").toList.distinct
      val part2 = x(1).split("").toList.distinct
      val part3 = x(2).split("").toList.distinct
      val dupe = part1.filter(x => part2.contains(x) && part3.contains(x))
      dupe
    })
    grouped
  }

  println(badgesList)

  var matches: List[String] = {
    val temp: ListBuffer[String] = ListBuffer()
    splitStringInTwo(input)(_.map(k => {
      val List(first, second) = k

      checkForMatch(first, second) {
        value => {
          temp += value
        }
      }
    }))
    temp.toList
  }

  val priorityList = (('a' to 'z').toList ++ ('A' to 'Z')).zipWithIndex.map { x => x match {
    case (element, idx) => (element, idx + 1)
  }}

  //println(matches)
  //println(priorityList)

  val result = matches.foldLeft(0){ (acc,item) => {
    val found = priorityList.filter { case (value, key) => {
      item == value.toString()
    }}(0)
    acc + found._2
  }}


  val result2 = badgesList.foldLeft(0) { (acc, item) => {
    val found = priorityList.filter { case (value, key) => {
      item == value.toString()
    }
    }(0)
    acc + found._2
  }
  }

  println(result2)

  def checkForMatch(word1: String, word2: String)(duplicate: String => Unit) = {
    breakable {
      for (index1 <- 0 until word1.length) {
        for (index2 <- 0 until word2.length) {
          if (word1(index1) == word2(index2)) {
            duplicate(word1(index1).toString)
            break
          }
        }
      }
    }
  }

  def main(args: Array[String]) = {

  }
}