package day2

import scala.io.Source

object Main {

  val input = Source.fromFile("input.txt").getLines.mkString("\n")

  sealed trait Weapon

  case object Rock extends Weapon
  case object Paper extends Weapon
  case object Scissor extends Weapon

  def getPointsOfRound(enemy: Weapon, me:Weapon) = {
      val score = enemy match {
        case Rock => me match {
          case Rock => 3
          case Paper => 6
          case Scissor => 0
        }
        case Paper => me match {
          case Rock => 0
          case Paper => 3
          case Scissor => 6
        }
        case Scissor => me match {
          case Rock => 6
          case Paper => 0
          case Scissor => 3
        }
      }
      score
  }

  def getScorePerWeapon(weaponOfChoie: Weapon) = {
    weaponOfChoie match {
      case Rock => 1
      case Paper => 2
      case Scissor => 3
    }
  }

  val entities = Map("A" -> Rock, "B" -> Paper, "C" -> Scissor)

  val encryptedEntities = Map("X" -> Rock, "Y" -> Paper, "Z" -> Scissor)

  val list = input.split("\n").map {k =>
    val split = k.split(" ")
    split match {
      case Array(x, y) =>
        (entities.get(x).getOrElse(null), encryptedEntities.get(y).getOrElse(null))
    }
  }.toList

  val totalScorePerGame = list.map { k => k match {
    case(x, y) => {
      val scoreRound = getPointsOfRound(x, y)
      val scoreChoice = getScorePerWeapon(y)

      scoreRound + scoreChoice
    }
  }}.sum

  println(totalScorePerGame)

  def main(args:Array[String]) = {

  }
}