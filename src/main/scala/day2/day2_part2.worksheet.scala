package day2

import scala.io.Source

object Main {

  val input = Source.fromFile("input.txt").getLines.mkString("\n")

  sealed trait Weapon

  case object Rock extends Weapon
  case object Paper extends Weapon
  case object Scissor extends Weapon

  sealed trait Result
  case object Win extends Result
  case object Lose extends Result
  case object Tie extends Result

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

  def getWeaponBasedOResult(result: Result, weapon: Weapon) = {
    val score = result match {
      case Win => weapon match {
        case Rock => Paper
        case Paper => Scissor
        case Scissor => Rock
      }
      case Tie => weapon match {
        case Rock => Rock
        case Paper => Paper
        case Scissor => Scissor
      }
      case Lose => weapon match {
        case Rock => Scissor
        case Paper => Rock
        case Scissor => Paper
      }
    }
    score
  }

  def getScorePerRound(result: Result) = {
    val value = result match {
      case Win => 6
      case Tie => 3
      case Lose => 0
    }
    value
  }

  val entities = Map("A" -> Rock, "B" -> Paper, "C" -> Scissor)

  val encryptedEntities = Map("X" -> Lose, "Y" -> Tie, "Z" -> Win)

  val list = input.split("\n").map {k =>
    val split = k.split(" ")
    split match {
      case Array(x, y) =>
        (entities.get(x).getOrElse(null), encryptedEntities.get(y).getOrElse(null))
    }
  }.toList


  val totalScorePerGame = list.map { k => k match {
    case(x, y) => {
      val weaponBasedOnResult = getWeaponBasedOResult(y, x)
      val scorePerRound = getScorePerRound(y)
      val scoreForWeapon = getScorePerWeapon(weaponBasedOnResult)

      val total = scorePerRound + scoreForWeapon
      total
    }
  }}.sum

  println(totalScorePerGame)

  def main(args:Array[String]) = {

  }
}