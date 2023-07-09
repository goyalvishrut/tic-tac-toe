package model

enum class Piece {
    X, O
}

fun Piece.toOppositePiece() = if (this == Piece.X) Piece.O else Piece.X
