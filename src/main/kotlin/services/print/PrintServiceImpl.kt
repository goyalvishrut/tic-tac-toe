package services.print

import model.Piece

class PrintServiceImpl : PrintService {

    override fun addPlayer(playerName: String, playerChoice: Piece) {
        println("Player added name: $playerName having choice ${playerChoice.name}")
    }

    override fun playerMoved(board: List<List<String?>>?) {
        if (board == null) {
            println("Invalid Move")
        } else {
            println("---------------------------------")
            board.forEach {
                println("${it[0] ?: "-"} ${it[1] ?: "-"} ${it[2] ?: "-"}")
            }
            println("---------------------------------")
        }
    }

    override fun gameStarted(board: List<List<String?>>) {
        println(board)
    }

    override fun showWinner(winner: String?) {
        winner?.let { println("$it won the game") }
    }
}
