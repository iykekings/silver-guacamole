package part2

import java.io.File

fun main() {
    println(solution())
}

fun String.parseMove(): Triple<(Int, Int) -> Int, Int, Int> =
    this.split(" ").let { s ->
        val value = s[1].toInt()
        when (s.first()) {
            "forward" -> Triple({ a, b -> b * value + a }, 0, value)
            "down" -> Triple({ a, _ -> a }, value, 0)
            else -> Triple({ a, _ -> a }, -value, 0)
        }
    }
//2006917119

fun solution(): Int {
    return File("../input.txt")
        .readLines()
        .map { it.parseMove() }
        .fold(Triple(0, 0, 0))
        { (a, b, c), (fn, x, y) -> Triple(fn(a, b), b + x, c + y) }
        .let { (f, _, s) ->
            f * s
        }
}
