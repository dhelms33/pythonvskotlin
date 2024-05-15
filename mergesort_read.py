import time
import random
import sys

sys.setrecursionlimit(100000)


def mergeSort(alist):
    """Perform Merge Sort on a list."""
    start_time = time.time()

    # Helper function for merging two sorted sublists
    def merge(left, right):
        result = []
        i = j = 0

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                result.append(left[i])
                i += 1
            else:
                result.append(right[j])
                j += 1

        result.extend(left[i:])
        result.extend(right[j:])
        return result

    if len(alist) <= 1:
        return alist, time.time() - start_time

    mid = len(alist) // 2
    left, left_time = mergeSort(alist[:mid])
    right, right_time = mergeSort(alist[mid:])

    # Merge the sorted sublists
    result = merge(left, right)

    elapsed_time = time.time() - start_time
    return result, elapsed_time + left_time + right_time


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

    try:
        with open('py_vs_X_assign2.txt', 'r') as file:
            lines = file.readlines()
            input_list = [int(x.strip()) for x in lines]
    except FileNotFoundError:
        print("Error: File 'py_vs_X_assign2.txt' not found.")
        sys.exit(1)

    testFunction(mergeSort, list(input_list))
