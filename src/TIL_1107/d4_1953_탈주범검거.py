from collections import deque

def bfs():
    while q:
        global cnt
        pr, pc, time = q.popleft()

        if not visited[pr][pc]:
            cnt += 1
            visited[pr][pc] = True

        if time==L:
            continue

        presentOut = direction[mapp[pr][pc]]
        for k in presentOut:
            nr = pr + dr[k]
            nc = pc + dc[k]
            if 0<=nr<N and 0<=nc<M and mapp[nr][nc] and not visited[nr][nc]:
                if k<=1:
                    k = 1-k
                else:
                    k = 5-k
                nextIn = direction[mapp[nr][nc]]
                if k in nextIn:
                    q.append((nr, nc, time+1))


direction = [[], [0, 1, 2, 3], [0, 1], [2, 3], [0, 3], [1, 3], [1, 2], [0, 2]]
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

T = int(input())
for tc in range(1, T+1):
    N, M, R, C, L = map(int, input().split())
    mapp = [list(map(int, input().split())) for _ in range(N)]
    visited = [[False]*M for _2 in range(N)]

    q = deque()
    q.append((R, C, 1))
    
    cnt = 0
    bfs()
    print(f'#{tc} {cnt}')
