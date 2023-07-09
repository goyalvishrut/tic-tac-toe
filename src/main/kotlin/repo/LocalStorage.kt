package repo

import model.Piece

interface LocalStorage {

    fun addPlayer(piece: Piece, name: String)

    fun getPlayerName(piece: Piece): String

    fun getBoard(): List<List<String?>>

    fun addPiece(piece: Piece, row: Int, column: Int)
}
