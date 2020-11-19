def binarySearch(l, r, target, direction):
    global cnt
    if l == r:
        if A[l] == target:
            cnt += 1
        return

    mid = (l + r) // 2
    if target == A[mid]:
        cnt += 1
        return
    elif target < A[mid]:
        if direction == -1:
            return
        binarySearch(l, mid-1, target, -1)
    else:
        if direction == 1:
            return
        binarySearch(mid+1, r, target, 1)


T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    A.sort()
    B = list(map(int, input().split()))
    cnt = 0
    for i in range(0, M):
        binarySearch(0, N-1, B[i], 0)
    print(f'#{tc} {cnt}')