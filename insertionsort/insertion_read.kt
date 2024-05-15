/**
 * Dereck Helms
 * CS 4050
 */

import java.io.File

fun insertionSort(alist: MutableList<Int>): Pair<List<Int>, Double> {
    val startTime = System.currentTimeMillis()

    for (i in 1 until alist.size) {
        val key = alist[i]
        var j = i - 1
        while (j >= 0 && key < alist[j]) {
            // Shift elements greater than key to the right
            alist[j + 1] = alist[j]
            j--
        }
        // Insert the key at its correct position
        alist[j + 1] = key
    }

    val elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0
    return Pair(alist, elapsedTime)
}

fun testFunction(sortFunction: (MutableList<Int>) -> Pair<List<Int>, Double>, alist: MutableList<Int>) {
    val alist2 = alist.toMutableList()
    val res = sortFunction(alist.toMutableList())
    println("Using ${sortFunction::class.simpleName} to sort list: ${alist.take(10)}... w/ ${alist.size} items")
    println("    sort time: ${res.second} seconds")
    alist2.sort()
    println("    sorted correctly?: ${if (res.first == alist2) "y :)" else "n :("}")
}

fun main() {
    // Read file into an array
    val arrayFromFile = File("py_vs_X_assign2.txt").readLines().map { it.toInt() }.toMutableList()

    // Test insertion sort
    testFunction(::insertionSort, arrayFromFile)
}
