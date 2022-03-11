object Play extends App {
  val game = new Game

  while (true) {
    println("Tic Tac Toe game. Enter the number. Player O starts")
    game.renderBoard(game.elements)
    game.changeTurn(game.elements)
  }
}
