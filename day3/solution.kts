import java.io.File

fun folder(xs: List<Int>, ys: String) =
        ys.toCharArray().map { it.toString().toInt(2) }.zip(xs).map { (a, b) -> a + b }

fun revBin(s: String) = s.map { if (it == '1') '0' else '1' }.joinToString("")

fun solution(path: String): Int {
    return File(path).readLines().let {
        it
          .fold((0..it.first().length).map { 0 }, ::folder)
          .joinToString("") { d -> if (d > (it.size / 2)) "1" else "0" }
          .let { bin -> bin.toInt(2) * revBin(bin).toInt(2) }
    }
}

solution("./test.txt")
solution("./input.txt")