package services.game

import model.Piece
import model.toOppositePiece
import repo.LocalStorage

class GameServiceImpl(private val localStorage: LocalStorage) : GameService {

    private var currentUser: Piece = Piece.X

    override fun addPlayer(piece: Piece, name: String) {
        localStorage.addPlayer(piece, name)
    }

    override fun addPiece(row: Int, column: Int): List<List<String?>>? {
        if (row !in 0..2 || column !in 0..2) {
            return null
        }
        val board = localStorage.getBoard()
        return if (board[row][column] == null) {
            localStorage.addPiece(currentUser, row, column)
            currentUser = currentUser.toOppositePiece()
            localStorage.getBoard()
        } else {
            null
        }
    }

    override fun getBoard(): List<List<String?>> = localStorage.getBoard()

    override fun isWinner(row: Int, column: Int): String? {
        val board = localStorage.getBoard()
        val pieceToCheck = currentUser.toOppositePiece()

        // checked row
        if (board[row][0] == pieceToCheck.name && board[row][1] == pieceToCheck.name && board[row][2] == pieceToCheck.name) {
            return localStorage.getPlayerName(currentUser.toOppositePiece())
        }

        // checked column
        if (board[0][column] == pieceToCheck.name && board[1][column] == pieceToCheck.name && board[2][column] == pieceToCheck.name) {
            return localStorage.getPlayerName(currentUser.toOppositePiece())
        }

        // check diagonal
        if ((board[0][0] == pieceToCheck.name && board[1][1] == pieceToCheck.name && board[2][2] == pieceToCheck.name) ||
            (board[0][2] == pieceToCheck.name && board[1][1] == pieceToCheck.name && board[2][0] == pieceToCheck.name)
        ) {
            return localStorage.getPlayerName(currentUser.toOppositePiece())
        }
        return null
    }
}
