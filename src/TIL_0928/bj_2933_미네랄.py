from collections import deque

dr = [-1, 0, 0, 1]
dc = [0, -1, 1, 0]
# 상, 좌, 우 (+하)

R, C = map(int, input().split())

mapp = [list(input()) for _ in range(0,R)]

N = int(input())
height = list(map(int, input().split()))


q = deque()


for i in range(0, N):
    turn = 0
    h = height[i]
    r0 = R-h 
    c0 = C
    if i%2==0:
        turn = 1
        for c in range(0, C):
            if mapp[r0][c]=='x':
                c0 = c
                break
    else:
        turn = 2
        for c in range(1, C+1):
            if mapp[r0][C-c]=='x':
                c0 = C-c
                break
    if c0==C:
        continue

    mapp[r0][c0] = '.'
    
    cnt_clst = 0
    q_drop = deque()

    for j in range(0, 3):
        if j==turn:
            continue
        nr = r0 + dr[j]
        nc = c0 + dc[j]
        if 0<=nr<R and 0<=nc<C and mapp[nr][nc]=='x':
            q.append((nr, nc))
            max_r = nr
            last_c = nc
            visited = [[False] * C for _ in range(0, R)]
            while q:
                pr, pc = q.popleft()
                for k in range(0, 4):
                    nr = pr + dr[k]
                    nc = pc + dc[k]
                    if 0<=nr<R and 0<=nc<C and visited[nr][nc]==False:
                        if mapp[nr][nc]=='x':
                            if nr > max_r:
                                max_r = nr
                                last_c = nc 
                            q.append((nr, nc))
                            visited[nr][nc] = True

            if max_r == R-1:
                continue
                # 연결되어 있는 경우   
            else:
                q.append((max_r, last_c))
                cnt_clst += 1
                q_drop.append((max_r, last_c, 0))
                mapp[max_r][last_c] = '.'
                visited = [[False] * C for _ in range(0, R)]
                while q:
                    pr, pc = q.popleft()
                    for k in range(0, 4):
                        nr = pr + dr[k]
                        nc = pc + dc[k]
                        if 0<=nr<R and 0<=nc<C and visited[nr][nc]==False :
                            if mapp[nr][nc]=='x':
                                mapp[nr][nc] = '.'
                                q.append((nr, nc))
                                visited[nr][nc] = True
                                q_drop.append((nr, nc, 0))
                                cnt_clst += 1

    stop = False                                
    time = 0
    cnt_shift = 0
    while q_drop:
        if cnt_shift==cnt_clst:
            time += 1
            cnt_shift = 0
        pr, c, p_time = q_drop.popleft()

        if stop==False:
            cnt_shift += 1
            nr = pr + 1
            if nr==R or mapp[nr][c]=='x':
                mapp[pr][c] = 'x'
                stop = True
            else:
                q_drop.append((nr, c, p_time+1))
                
        else:
            if cnt_shift == 0:
                mapp[pr-1][c] = 'x'
            else:
                if time!=p_time:
                    mapp[pr-1][c] = 'x'
                    cnt_shift -= 1
                else:
                    mapp[pr][c] = 'x'


for r in range(0, R):
    for c in range(0, C):
        print(mapp[r][c], end='')
    if r < R-1:
        print()


