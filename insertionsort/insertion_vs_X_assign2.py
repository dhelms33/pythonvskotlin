"""
Dereck Helms
CS 4050
"""

import time
import random
import sys

sys.setrecursionlimit(100000)

def insertionSort(alist):
    """Perform Insertion Sort on a list."""
    start_time = time.time()

    for i in range(1, len(alist)):
        key = alist[i]
        j = i - 1
        while j >= 0 and key < alist[j]:
            # Shift elements greater than key to the right
            alist[j + 1] = alist[j]
            j -= 1
        # Insert the key at its correct position
        alist[j + 1] = key

    elapsed_time = time.time() - start_time
    return alist, elapsed_time


if __name__ == '__main__':
    """ Check if the program is being run directly (i.e. not being imported) """

    def testFunction(sort_function, alist):
        """ A test utility function. """
        alist2 = alist.copy()
        res = sort_function(list(alist))
        print(f"Using {sort_function.__name__} to sort list: {alist[:10]}... w/ {len(alist)} items")
        print(f"    sort time: {res[1]:.4f} seconds")
        alist2.sort()
        print(f"    sorted correctly?: {'y :)' if res[0] == alist2 else 'n :('}")

    list1 = [54, 26, 93, 17, 77, 31, 44, 55, 20]  # helpful for early testing
    testFunction(insertionSort, list(list1))

    random.seed(1)
    list2 = list(range(5000))
    random.shuffle(list2)
    testFunction(insertionSort, list(list2))

    list3 = list(range(6000, 1000, -1))
    testFunction(insertionSort, list(list3))
