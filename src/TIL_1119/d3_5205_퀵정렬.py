def partition(l, r):
    pivot_val = arr[l]
    i = l + 1
    j = r
    while i <= j:
        while i <= r and arr[i] <= pivot_val:
            i += 1
        while j > l and arr[j] >= pivot_val:
            j -= 1
        if i < j:
            arr[i], arr[j] = arr[j], arr[i]

    arr[j], arr[l] = pivot_val, arr[j]
    return j


def quickSort(l, r):
    if l < r:
        p = partition(l, r)
        quickSort(l, p-1)
        quickSort(p+1, r)


T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = list(map(int, input().split()))
    quickSort(0, N-1)
    print(f'#{tc} {arr[N >> 1]}')