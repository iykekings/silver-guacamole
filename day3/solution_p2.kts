import java.io.File

fun solution(path: String): Int {
    return File(path).readLines().let {
        val i = foldRec(it) { a, b -> a >= b }.toInt(2)
        val ii = foldRec(it) { a, b -> a < b }.toInt(2)
        i * ii
    }
}

fun selectNext(ls: List<Char>, fn: (Int, Double) -> Boolean): Char {
    val count = ls.count { it == '1' }
    val isOne = fn(count, ls.size.toDouble() / 2.0)
    return if (isOne) { '1' } else { '0' }
}

fun foldRec(lines: List<String>, fn: (Int, Double) -> Boolean): String {
    tailrec fun foldRec(lines: List<String>, index: Int): List<String> {
        if (lines.size <= 1) return lines
        val sel = selectNext(lines.map { it[index] }, fn)
        val selected = lines.filter { it[index] == sel }
        return foldRec(selected, index + 1)
    }
    return foldRec(lines, 0).first()
}

solution("./test.txt")
solution("./input.txt")
