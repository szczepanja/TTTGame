import scala.io.StdIn.readLine
import scala.sys.exit

class Game {
  val elements: Array[Char] = ('1' to '9').toArray
  val newElements: Array[Char] = ('1' to '9').toArray

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

  def readMove(table: Array[Char]): Int = {
    val number = readLine("Choose number: ")

    if (number.matches("[1-9]")) {
      if (table(number.toInt - 1).isDigit) {
        number.toInt - 1
      } else {
        println("Taken! ☹☹☹")
        readMove(table)
      }
    } else {
      println("Take number from 1 to 9")
      readMove(table)
    }
  }

  def changeTurn(table: Array[Char]): Unit = {
    table(readMove(table)) = changePlayer(table)
    renderBoard(table)

    if (!winner(table)) {
      changeTurn(table)
    } else {
      renderBoard(table)
    }
  }

  def winner(table: Array[Char]): Boolean = {
    winningList.foreach(combination => {
      if (combination.forall(table(_) == table(combination(0)))) {
        println("Player " + table(combination(0)) + " wins")

        val answer = readLine("Want to play again? (Y/n) ")

        if (answer == "Y" || answer == "y") {
          println("Enter the number. Player O starts")
          renderBoard(newElements)
          changeTurn(newElements)
        } else {
          exit()
        }
      }
    })
    false
  }
}
