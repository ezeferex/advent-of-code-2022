import java.util.*

fun processCrate(crates: List<String>): Pair<List<Stack<Char>>, List<Triple<Int, Int, Int>>> {
    val stacks = mutableListOf<Stack<Char>>()
    val lines = crates[0].split("\n")
    lines.last().split(" ")
        .filter(String::isNotBlank)
        .forEach { _ ->
            stacks.add(Stack<Char>())
        }

    for (i in lines.size - 2 downTo 0) {
        val line = lines[i]
        val chars = line.toCharArray()
        for (j in chars.indices step 4) {
            if (chars[j] == '[') {
                stacks[j / 4].push(chars[j + 1])
            }
        }
    }

    val moves = crates[1].split("\n")
        .map {
            val move = it.split(" ")
            Triple(move[1].toInt(), move[3].toInt(), move[5].toInt())
    }
    return stacks.toList() to moves
}

fun main() {
    fun part1() = processCrate(readInput("05").split("\n\n"))
        .let { (stacks, moves) ->
            moves.forEach { (amount, prev, pos) ->
                repeat(amount) {
                    stacks[pos - 1].push(stacks[prev - 1].pop())
                }
            }
            stacks
        }.let {
            var message = ""
            repeat(it.size) { index ->
                message += it[index].peek()
            }
            message
        }

    fun part2() = processCrate(readInput("05").split("\n\n"))
        .let {(stacks, moves) ->
            moves.forEach { (amount, prev, pos) ->
                val stackAux = Stack<Char>()
                repeat(amount) {
                    stackAux.push(stacks[prev - 1].pop())
                }
                repeat(amount) {
                    stacks[pos - 1].push(stackAux.pop())
                }
            }
            stacks
        }.let {
            var message = ""
            repeat(it.size) { index ->
                message += it[index].peek()
            }
            message
        }

    println( "Part 1: " + part1())
    println( "Part 2: " + part2())
}