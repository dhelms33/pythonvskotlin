/**
 * Dereck Helms
 * CS 4050
 */

 import java.util.Random

 fun insertionSort(alist: MutableList<Int>): Pair<List<Int>, Double> {
     val startTime = System.currentTimeMillis()
 
     for (i in 1 until alist.size) {
         val key = alist[i]
         var j = i - 1
         while (j >= 0 && key < alist[j]) {
             // Shift elements greater than key to the right
             alist[j + 1] = alist[j]
             j -= 1
         }
         // Insert the key at its correct position
         alist[j + 1] = key
     }
 
     val elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0
     return Pair(alist, elapsedTime)
 }
 
 fun testFunction(sortFunction: (MutableList<Int>) -> Pair<List<Int>, Double>, alist: MutableList<Int>) {
     val alist2 = ArrayList(alist)
     val res = sortFunction(ArrayList(alist))
     println("Using ${sortFunction::class.simpleName} to sort list: ${alist.take(10)}... w/ ${alist.size} items")
     println("    sort time: ${res.second} seconds")
     alist2.sort()
     println("    sorted correctly?: ${if (res.first == alist2) "y :)" else "n :("}")
 }
 
 fun main() {
     // Test insertion sort
     val list1 = listOf(54, 26, 93, 17, 77, 31, 44, 55, 20).toMutableList()  // helpful for early testing
     testFunction(::insertionSort, list1)
 
     val random = Random(1)
     val list2 = (0 until 5000).toList().shuffled(random).toMutableList()
     testFunction(::insertionSort, list2)
 
     val list3 = (6000 downTo 1000 step 1).toList().toMutableList()
     testFunction(::insertionSort, list3)
 }
 