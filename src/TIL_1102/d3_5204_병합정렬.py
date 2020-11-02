def mergeSort(arr, l, r):
    if l < r-1:
        mid = (l + r)//2
        mergeSort(arr, l, mid)
        mergeSort(arr, mid, r)
        merge(arr, l, mid, r)


def merge(arr, l, mid, r):
    global cnt

    i = l
    j = mid
    sortedArr = []
    while i < mid and j < r:
        if arr[i] <= arr[j]:
            sortedArr.append(arr[i])
            i += 1
        else:
            sortedArr.append(arr[j])
            j += 1

    if i == mid:
        for y in range(j, r):
            sortedArr.append(arr[y])
    else:
        cnt += 1
        for x in range(i, mid):
            sortedArr.append(arr[x])

    for k in range(0, r-l):
        arr[l+k] = sortedArr[k]


T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = list(map(int, input().split()))
    cnt = 0
    mergeSort(arr, 0, N)
    print(f'#{tc} {arr[N//2]} {cnt}')
