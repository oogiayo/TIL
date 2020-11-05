from collections import deque

def bfs():
    while q:
        num = q.popleft()
        if num==M:
            print(f'#{tc} {visited[num]}')
            break
        next(num, num+1)
        next(num, num-1)
        next(num, num*2)
        next(num, num-10)


def next(pnum, nnum):
    if 0 <= nnum < maxSize:
        if visited[nnum]==0 or (visited[nnum] > visited[pnum]+1):
            visited[nnum] = visited[pnum] + 1
            q.append(nnum)


T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    maxSize = (M+1)*2
    visited = [0]*maxSize
    q = deque()
    q.append(N)
    bfs()