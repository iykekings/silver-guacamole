import java.io.File

fun depthIncreaseCount(): Int {
    val input = File("./input").readLines().map { it.toInt() }
    return input.zipWithNext().fold(0, { acc, e -> if (e.first < e.second) acc + 1 else acc })
}

println(depthIncreaseCount())
