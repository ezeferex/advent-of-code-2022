// A and X are Rock (1 point)
// B and Y are Paper (2 points)
// C and Z are Scissors (3 points)
// 6 points if won
// 3 points if draw
// 0 point if lost

fun scoreShape(shape: String) = when(shape) {
    "X" -> 1
    "Y" -> 2
    "Z" -> 3
    else -> 0
}

fun scoreRock(shape: String) = when(shape) {
    "A" -> 3
    "C" -> 6
    else -> 0
}

fun scorePaper(shape: String) = when(shape) {
    "B" -> 3
    "A" -> 6
    else -> 0
}

fun scoreScissors(shape: String) = when(shape) {
    "C" -> 3
    "B" -> 6
    else -> 0
}

fun scoreResult(result: String) = when(result) {
    "Y" -> 3
    "Z" -> 6
    else -> 0
}

fun scoreShapeLose(shape: String) = when(shape) {
    "A" -> scoreShape("Z")
    "B" -> scoreShape("X")
    "C" -> scoreShape("Y")
    else -> 0
}

fun scoreShapeDraw(shape: String) = when(shape) {
    "A" -> scoreShape("X")
    "B" -> scoreShape("Y")
    "C" -> scoreShape("Z")
    else -> 0
}

fun scoreShapeWin(shape: String) = when(shape) {
    "A" -> scoreShape("Y")
    "B" -> scoreShape("Z")
    "C" -> scoreShape("X")
    else -> 0
}

fun scoreRoundPart1(opp: String, player: String) = scoreShape(player) + when(player) {
    "X" -> scoreRock(opp)
    "Y" -> scorePaper(opp)
    "Z" -> scoreScissors(opp)
    else -> 0
}

fun scoreRoundPart2(opp: String, result: String) = scoreResult(result) + when(result) {
    "X" -> scoreShapeLose(opp)
    "Y" -> scoreShapeDraw(opp)
    "Z" -> scoreShapeWin(opp)
    else -> 0
}

fun main() {

    fun part1() = "Part 1: " + readInput("02").split("\n")
        .sumOf { scoreRoundPart1(it.split(" ")[0], it.split(" ")[1]) }

    fun part2() = "Part 2: " + readInput("02").split("\n")
        .sumOf { scoreRoundPart2(it.split(" ")[0], it.split(" ")[1]) }

    println(part1())
    println(part2())
}
