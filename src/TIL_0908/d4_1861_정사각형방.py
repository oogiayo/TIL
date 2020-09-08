from collections import deque

T = int(input())

dr = [-1,1,0,0]
dc = [0,0,-1,1]

for tc in range(1, T+1):
    N = int(input())
    room = []
    for r in range(0, N):
        room.append(list(map(int, input().split())))

    m = [[0]*N for _ in range(0, N)]
    ans = [0, N*N]

    q = deque()    
    for r in range(0, N):
        for c in range(0, N):            
            q.append((r, c, 1, room[r][c]))
            while q:
                pr, pc, cnt, base = q.popleft()
                if m[pr][pc] > cnt:                    
                    continue

                if cnt > m[pr][pc]:
                    m[pr][pc] = cnt
            
                isEnd = True
                for k in range(0, 4):
                    nr = pr + dr[k]
                    nc = pc + dc[k]

                    if 0<=nr<N and 0<=nc<N and room[nr][nc]==room[pr][pc]+1:
                        q.appendleft((nr, nc, cnt+1, base))
                        isEnd = False

                if isEnd:
                    if cnt == ans[0] and base < ans[1]:
                        ans[1] = base
                    if cnt > ans[0]:
                        ans[0] = cnt
                        ans[1] = base
                    
    print(f'#{tc} {ans[1]} {ans[0]}')
