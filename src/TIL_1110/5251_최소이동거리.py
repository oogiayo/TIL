from collections import deque

def bfs():
    ans = 10*N
    while q:
        node, dist = q.popleft()
        if dist > ans:
            continue
        if node==N:
            if dist < ans:
                ans = dist
        for nextNode in range(1, N+1):
            if arr[node][nextNode]:
                q.append((nextNode, dist + arr[node][nextNode]))
    print(f'#{tc} {ans}')


T = int(input())
for tc in range(1, T+1):
    N, E = map(int, input().split())
    arr = [[0]*(N+1) for _ in range(0, N+1)]
    for i in range(0, E):
        s, e, w = map(int, input().split())
        arr[s][e] = w

    q = deque()
    q.append((0, 0))
    bfs()