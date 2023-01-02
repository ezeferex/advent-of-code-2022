fun String.getSections() = this.split(",")
    .map { it.split("-").let { section -> Pair(section[0].toInt(), section[1].toInt()) }}
    .let { pairSection -> Pair(pairSection[0], pairSection[1]) }

fun main() {
    fun part1() = readInput("04").split("\n")
        .count {
            val sections = it.getSections()
            (sections.second.first in sections.first.first..sections.first.second &&
             sections.second.second in sections.first.first..sections.first.second) ||
            (sections.first.first in sections.second.first..sections.second.second &&
            sections.first.second in sections.second.first..sections.second.second)
        }

    fun part2() = readInput("04").split("\n")
        .count {
            val sections = it.getSections()
            !(sections.second.first > sections.first.second ||
              sections.first.first > sections.second.second)
        }

    println("Part 1: " + part1())
    println("Part 2: " + part2())
}
