object Main {

  case class Elf(id: Int, totalCalories: Int)

  val input =
    """1000
      2000
      3000

      4000

      5000
      6000

      7000
      8000
      9000

      10000""".stripMargin


  val elvesTotalCaloriesList = input.split("\n\n").toList.zipWithIndex.map {
    case (element, elf) =>
      val total = element.split("\n").toList.map(_.trim).map(_.toInt).sum
      Elf(elf+1,total)
  }

  def getElfWithMostCalories(list: List[Elf]) = {
    list.maxBy(_.totalCalories)
  }

  println(getElfWithMostCalories(elvesTotalCaloriesList))




  def main(args:Array[String]) = {

  }
}