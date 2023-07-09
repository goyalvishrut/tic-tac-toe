package controller

import model.Piece
import services.game.GameService
import services.print.PrintService

class GameController(
    private val gameService: GameService,
    private val printService: PrintService,
) {

    fun addPlayer(playerChoice: Piece, playerName: String) {
        gameService.addPlayer(playerChoice, playerName)
        printService.addPlayer(playerName, playerChoice)
    }

    fun addPiece(row: Int, column: Int) {
        val board = gameService.addPiece(row, column)
        board.let {
            printService.playerMoved(it)
            it?.let {
                printService.showWinner(gameService.isWinner(row, column))
            }
        }
    }

    fun startGame() {
        printService.gameStarted(gameService.getBoard())
    }
}
