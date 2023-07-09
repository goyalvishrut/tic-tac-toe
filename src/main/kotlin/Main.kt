import controller.GameController
import repo.LocalStorageImpl
import services.game.GameServiceImpl
import services.print.PrintServiceImpl
import util.toPiece
import kotlin.system.exitProcess

private val localStorage = LocalStorageImpl()
private val gameService = GameServiceImpl(localStorage = localStorage)
private val printService = PrintServiceImpl()
private val gameController = GameController(gameService = gameService, printService = printService)

fun main() {
    testInput()

    val (player1Choice, player1Name) = readln().split(" ")
    val (player2Choice, player2Name) = readln().split(" ")

    gameController.addPlayer(player1Choice.toPiece(), player1Name)
    gameController.addPlayer(player2Choice.toPiece(), player2Name)
    gameController.startGame()

    while (true) {
        val input = readln()
        processInput(input.split(" "))
    }
}

fun processInput(input: List<String>) {
    if (input[0] == "exit") {
        exitProcess(1)
    } else {
        gameController.addPiece(input[0].toInt() - 1, input[1].toInt() - 1)
    }
}

fun testInput() {
    val input = listOf(
        "X Gaurav",
        "O Sagar",
        "2 2",
        "1 3",
        "1 1",
        "1 2",
        "2 2",
        "3 3",
        "exit",
    )
    gameController.addPlayer(input[0].split(" ")[0].toPiece(), input[0].split(" ")[1])
    gameController.addPlayer(input[1].split(" ")[0].toPiece(), input[1].split(" ")[1])
    input.subList(2, input.size).forEach {
        processInput(it.split(" "))
    }
}
