package util

import model.Piece

fun String.toPiece() = Piece.values().first { it.name.equals(this, ignoreCase = true) }
