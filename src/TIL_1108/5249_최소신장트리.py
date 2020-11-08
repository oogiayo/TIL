def prim():
    global ans
    for _ in range(V+1):
        minIdx = V+1
        minVal = 10000
        for i in range(0, V+1):
            if not visited[i] and dist[i] < minVal:
                minIdx = i
                minVal = dist[i]
                
        visited[minIdx] = True
        ans += minVal
        for v, w in e[minIdx]:
            if not visited[v] and w < dist[v]:
                dist[v] = w


T = int(input())
for tc in range(1, T+1):
    V, E = map(int, input().split())
    e = [[] for _ in range(V+1)]
    for _ in range(0, E):
        n1, n2, w = map(int, input().split())
        e[n1].append([n2, w])
        e[n2].append([n1, w])
    visited = [False] * (V+1)
    dist = [10000] * (V+1)
    dist[0] = 0

    ans = 0
    prim()
    print(f'#{tc} {ans}')