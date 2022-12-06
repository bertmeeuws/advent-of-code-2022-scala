package day2

object Main {

  sealed trait Weapon

  case object Rock extends Weapon
  case object Paper extends Weapon
  case object Scissor extends Weapon


  def whoWins(enemy: Weapon, me:Weapon) = {
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

      s"Score: ${score}"
  }

  val entities = Map("A" -> Rock)

  println(entities.get("A").getOrElse(""))

  println(whoWins(Rock, Scissor))
  println(whoWins(Paper, Scissor))



  def main(args:Array[String]) = {

  }
}