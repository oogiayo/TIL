def go(now, visitNum, tot):
    global ans
    if visitNum == N:
        if tot < ans:
            ans = tot
        return
    if visitNum == N-1:
        go(0, visitNum+1, tot + arr[now][0])
    else:
        for nextIdx in range(1, N):
            if not visited[nextIdx] and now!=nextIdx:
                visited[nextIdx] = True
                go(nextIdx, visitNum+1, tot + arr[now][nextIdx])
                visited[nextIdx] = False


T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(0, N)]
    visited = [False for _ in range(0, N)]
    visited[0] = True
    ans = 1000
    go(0, 0, 0)
    print(f'#{tc} {ans}')