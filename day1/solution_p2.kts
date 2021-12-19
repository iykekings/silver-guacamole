import java.io.File

fun solution(): Int {
    return File("./input")
            .readLines()
            .map { it.toInt() }
            .windowed(3, 1)
            .map { it.sum() }
            .zipWithNext { a, b -> a < b }
            .count { a -> a }
}

println(solution())
