def bfs():
    while q:
        px = q.pop(0)
        if px == K:
            print(visited[px])
            break
        next(px - 1, px)
        next(px + 1, px)
        next(px * 2, px)

def next(nx, px):
    if maxSize > nx >= 0 and visited[nx] == 0:
        visited[nx] = visited[px] + 1
        q.append(nx)

N, K = map(int, input().split())
maxSize = 100001
visited = [0] * maxSize
q = [N]
bfs()
