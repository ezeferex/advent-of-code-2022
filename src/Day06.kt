
fun String.detectPacket(windowSize: Int) = windowedSequence(windowSize) {
    it.toSet().count() == it.length
}.indexOf(true) + windowSize

fun main() {

    fun part1() = readInput("06").detectPacket(4)

    fun part2() = readInput("06").detectPacket(14)

    println("Part 1: " + part1())
    println("Part 2: " + part2())
}