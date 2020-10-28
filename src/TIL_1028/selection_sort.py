import random

def selectionSort(numList, N):
    for i in range(0, N):
        min_idx = i
        for j in range(i+1, N):
            if numList[j] < numList[min_idx]:
                min_idx = j
        numList[i], numList[min_idx] = numList[min_idx], numList[i]
    return numList



nums = [i for i in range(1, 51)]
N = len(nums)
random.shuffle(nums)

print('<Initial List>')
print(nums)
print()

print('<Selection Sort>')
print(selectionSort(nums, N))
