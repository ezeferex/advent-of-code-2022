import java.io.File

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src/resources", "input$name.txt")
    .readText()

fun String.splitInTwo() = take(length / 2) to substring(length / 2)
