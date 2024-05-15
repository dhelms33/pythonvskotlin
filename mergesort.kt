/**
 * Dereck Helms
 * CS 4050
 */
import java.io.File
import java.io.IOException

fun mergeSort(alist: List<Int>): Pair<List<Int>, Double> {
    // Perform Merge Sort on a list
    val startTime = System.currentTimeMillis()

    fun merge(left: List<Int>, right: List<Int>): List<Int> {
        val result = mutableListOf<Int>()
        var i = 0
        var j = 0

        while (i < left.size && j < right.size) {
            if (left[i] < right[j]) {
                result.add(left[i])
                i++
            } else {
                result.add(right[j])
                j++
            }
        }

        result.addAll(left.subList(i, left.size))
        result.addAll(right.subList(j, right.size))
        return result
    }

    if (alist.size <= 1) {
        return Pair(alist, (System.currentTimeMillis() - startTime) / 1000.0)
    }

    val mid = alist.size / 2
    val left = mergeSort(alist.subList(0, mid))
    val right = mergeSort(alist.subList(mid, alist.size))

    val result = merge(left.first, right.first)

    val elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0
    return Pair(result, elapsedTime + left.second + right.second)
}

fun testFunction(sortFunction: (List<Int>) -> Pair<List<Int>, Double>, alist: List<Int>) {
    // A test utility function
    val alist2 = alist.toMutableList()
    val res = sortFunction(alist)
    println("Using ${sortFunction::class.simpleName} to sort list: ${alist.take(10)}... w/ ${alist.size} items")
    println("    sort time: ${"%.4f".format(res.second)} seconds")
    alist2.sort()
    println("    sorted correctly?: ${if (res.first == alist2) "y :)" else "n :("}")
}

fun main() {
    try {
        val lines = File("py_vs_X_assign2.txt").readLines()
        val inputList = lines.map { it.toInt() }

        testFunction(::mergeSort, inputList)
    } catch (e: IOException) {
        println("Error: File 'py_vs_X_assign2.txt' not found or cannot be read.")
        System.exit(1)
    }
}
