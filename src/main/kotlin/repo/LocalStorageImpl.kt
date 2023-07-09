package repo

import model.Piece

class LocalStorageImpl : LocalStorage {

    private val row: List<String?> = listOf(null, null, null)
    private val board: MutableList<MutableList<String?>> =
        mutableListOf(row.toMutableList(), row.toMutableList(), row.toMutableList())

    private val users: MutableMap<Piece, String> = mutableMapOf()

    override fun addPlayer(piece: Piece, name: String) {
        users[piece] = name
    }

    override fun getPlayerName(piece: Piece): String {
        return users[piece]!!
    }

    override fun getBoard(): List<List<String?>> {
        return board
    }

    override fun addPiece(piece: Piece, row: Int, column: Int) {
        board[row][column] = piece.name
    }
}
