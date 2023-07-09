package services.game

import model.Piece

interface GameService {

    fun addPlayer(piece: Piece, name: String)

    fun addPiece(row: Int, column: Int): List<List<String?>>?

    fun getBoard(): List<List<String?>>

    fun isWinner(row: Int, column: Int): String?
}
