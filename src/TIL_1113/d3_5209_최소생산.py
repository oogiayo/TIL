def backTracking(idx, tot):
    global ans
    if tot > ans:
        return
        
    if idx==N:
        if tot < ans:
            ans = tot
        return

    for product in range(0, N):
        if not visited[product]:
            visited[product] = True
            backTracking(idx+1, tot+arr[product][idx])
            visited[product] = False


T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(0, N)]
    visited = [False for _ in range(0, N)]
    m = [[0]*N for _ in range(0, N)]
    ans = 99 * N
    backTracking(0, 0)
    print(f'#{tc} {ans}')