package services.print

import model.Piece

interface PrintService {

    fun addPlayer(playerName: String, playerChoice: Piece)

    fun playerMoved(board: List<List<String?>>?)

    fun gameStarted(board: List<List<String?>>)

    fun showWinner(winner: String?)
}
