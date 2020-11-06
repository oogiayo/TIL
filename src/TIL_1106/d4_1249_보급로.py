from collections import deque

def bfs():
    while q:
        pr, pc = q.popleft()
        if pr==N-1 and pc==N-1:
            continue
        for k in range(0, 4):
            nr = pr + dr[k]
            nc = pc + dc[k]
            if 0<=nr<N and 0<=nc<N:
                if m[nr][nc] > m[pr][pc] + mapp[nr][nc]:
                    m[nr][nc] = m[pr][pc] + mapp[nr][nc]
                    q.append((nr, nc))


dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    mapp = [list(map(int, input())) for _ in range(N)]
    m = [[100000]*N for _ in range(N)]
    m[0][0] = 0

    q = deque()
    q.append((0, 0))
    bfs()
    print(f'#{tc} {m[N-1][N-1]}')
