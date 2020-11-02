import random

def partition(l, r):
    pivot = l
    i = l + 1
    j = r
    while i < j:
        while i < r and arr[i] <= arr[pivot]:
            i += 1
        while j > l and arr[j] >= arr[pivot]:
            j -= 1
        if i < j:
            arr[i], arr[j] = arr[j], arr[i]
        print(arr)

    arr[j], arr[pivot] = arr[pivot], arr[j]
    print(j, arr[j])
    return j


def quickSort(l, r):
    if l < r:
        p = partition(l, r)
        quickSort(l, p-1)
        quickSort(p+1, r)


arr = [i for i in range(1, 10)]
N = len(arr)
random.shuffle(arr)
print(arr)
quickSort(0, N-1)
print(arr)
