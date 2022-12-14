object Constants {
    const val UPPER_CASE_PRIORITY = 38
    const val LOWER_CASE_PRIORITY = 96
}

fun Char.getPriority() = code - if (isLowerCase()) Constants.LOWER_CASE_PRIORITY else Constants.UPPER_CASE_PRIORITY

    fun main() {
        fun part1() = "Part 1: " + readInput("03").split("\n")
        .sumOf {
            val pockets = it.splitInTwo()
            var itemType = ' '
            for (item in pockets.first.iterator()) {
                if (item in pockets.second) {
                    itemType = item
                    break
                }
            }
            itemType.getPriority()
        }

    fun part2() = "Part 2: " + readInput("03").split("\n")
        .windowed(3, 3)
        .sumOf {
            var items = it[0].toSet()
            it.forEach { bag -> items = items.intersect(bag.toSet()) }
            items.first().getPriority()
        }

    println(part1())
    println(part2())
    }
