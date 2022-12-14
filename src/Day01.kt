fun main() {
    fun part1() =  "Part 1: " + readInput("01").split("\n\n")
        .maxOfOrNull { it.split("\n").sumOf(String::toInt) }

    fun part2() =  "Part 2: " + readInput("01").split("\n\n")
        .map { it.split("\n").sumOf(String::toInt) }
        .sortedDescending()
        .take(3)
        .sum()

    println(part1())
    println(part2())
}
