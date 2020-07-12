from collections import deque

def bfs(r0, c0):
    q = deque()
    q.appendleft([r0, c0, 0])
    dist[0][r0][c0] = 1
    while len(q)!=0:
        x, y, wall = q.popleft()
        for k in range(0, 4):
            nr = x + dr[k]
            nc = y + dc[k]
            
            if N>nr>=0 and M>nc>=0 and dist[wall][nr][nc]==0 and maap[wall][nr][nc]==0:
                q.appendleft([nr, nc, wall])
                dist[wall][nr][nc] = dist[wall][x][y]+1

            if wall==0 and N>nr>=0 and M>nc>=0 and dist[wall+1][nr][nc]==0 and maap[wall][nr][nc]==1:
                q.appendleft([nr, nc, 1])
                dist[1][nr][nc] = dist[0][x][y]+1

    if dist[0][N-1][M-1]!=0 and dist[1][N-1][M-1]!=0:
        print(min(dist[0][N-1][M-1], dist[1][N-1][M-1]))

    elif dist[0][N-1][M-1]==0 and dist[1][N-1][M-1]==0:
        print(-1)

    else:
        print(max(dist[0][N-1][M-1], dist[1][N-1][M-1]))
# end of BFS

N, M = map(int, input().split())
dr = [-1,1,0,0]
dc = [0,0,-1,1]
maap = [[[0 for c in range(M)] for r in range(N)] for z in range(2)]
dist = [[[0 for c in range(M)] for r in range(N)] for z in range(2)]

for r in range(0, N):
    row = input()
    for c in range(0, len(row)):
        maap[0][r][c] = int(row[c:c+1])
        maap[1][r][c] = int(row[c:c+1])

bfs(0, 0)

