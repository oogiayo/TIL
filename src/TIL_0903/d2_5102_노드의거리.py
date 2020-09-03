from collections import deque

T = int(input())

for tc in range(1, T+1):
    V, E = map(int, input().split())
    arr = [[0]*(V+1) for _ in range(0, V+1)]
    visited = [False] * (V+1)

    for i in range(0, E):
        a, b = map(int, input().split())
        arr[a][b] = 1
        arr[b][a] = 1
    S, G = map(int, input().split())
    visited[S] = True

    q = deque()
    for c in range(1, V+1):
        if arr[S][c]==1 and visited[c]==False:
            visited[c] = True
            q.append((c, 1))

    ans = V
    while q:
        now, cnt = q.popleft()
        if now == G:
            if cnt < ans:
                ans = cnt
        
        for nxt in range(1, V+1):
            if arr[now][nxt]==1 and visited[nxt]==False:
                visited[nxt] = True
                q.append((nxt, cnt+1))

    if ans==V:
        ans = 0       
    print(f'#{tc} {ans}')
