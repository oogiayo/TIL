def distribute(idx, prb):
    global ans
    if prb < ans: return
    if prb==0:
        return
    if idx==N:
        if prb > ans:
            ans = prb
            return
    for i in range(0, N):
        if not visited[i] and arr[idx][i]:
            visited[i] = True
            distribute(idx+1, prb * arr[idx][i]/100)
            visited[i] = False


T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [[0]*N for _ in range(N)]
    for i in range(0, N):
        line = list(map(int, input().split()))
        for j in range(0, N):
            arr[j][i] = line[j]
    visited = [False for _ in range(N)]
    ans = 0
    distribute(0, 100)
    print(f'#{tc}','%.6f'%ans)
