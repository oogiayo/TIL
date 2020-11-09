from collections import deque

def bfs():
    while q:
        pr, pc = q.popleft()
        for k in range(0, 4):
            nr = pr + dr[k]
            nc = pc + dc[k]
            if 0<=nr<N and 0<=nc<N:
                fuel = 1
                if arr[nr][nc] > arr[pr][pc]:
                    fuel += arr[nr][nc] - arr[pr][pc]
                if acc[nr][nc] > acc[pr][pc] + fuel:
                    acc[nr][nc] = acc[pr][pc] + fuel
                    q.append((nr, nc))


dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    acc = [[100000]*N for _ in range(N)]
    acc[0][0] = 0
    m = [x for x in range(2*N)]
    q = deque()
    q.append((0, 0))
    bfs()

    print(f'#{tc} {acc[N-1][N-1]}')