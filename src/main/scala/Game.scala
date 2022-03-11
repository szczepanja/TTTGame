class Game {
  val elements: Array[Char] = ('1' to '9').toArray

  val winningList: List[List[Int]] = List(
    List(0, 1, 2),
    List(3, 4, 5),
    List(6, 7, 8),
    List(0, 3, 6),
    List(1, 4, 7),
    List(2, 5, 8),
    List(0, 4, 8),
    List(2, 4, 6)
  )

  def renderBoard(table: Array[Char]): Unit = {
    println(table.grouped(3).map(_.mkString(" ")).mkString("\n", "\n", " "))
  }

  def changePlayer(table: Array[Char]): Char = {
    val nextTurn = table.count(_.isDigit)
    if (nextTurn % 2 == 0) 'X' else 'O'
  }
}
