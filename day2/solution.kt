package part1

import java.io.File

fun main() {
    println(solution())
}

fun String.parseMove(): Pair<Int, Int> =
        this.split(" ").let {
            val value = it[1].toInt()
            when (it.first()) {
                "forward" -> Pair(0, value)
                "down" -> Pair(value, 0)
                else -> Pair(-value, 0)
            }
        }

fun solution(): Int {
    return File("../input.txt")
            .readLines()
            .fold(Pair(0, 0)) { (x, y), it ->
                val (a, b) = it.parseMove()
                Pair(x + a, y + b)
            }
            .let { (f, s) -> f * s }
}
