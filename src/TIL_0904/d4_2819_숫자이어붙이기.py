from collections import deque

dr = [-1,1,0,0]
dc = [0,0,-1,1]

T = int(input())
for tc in range(1, T+1):
    matrix = [input().split() for r in range(4)]
    
    q = deque()
    numSet = set()

    for r in range(0, 4):
        for c in range(0, 4):
            q.append((r, c, matrix[r][c]))
            
            while q:
                pr, pc, num = q.popleft()

                if len(num)==7:
                    numSet.add(num)
                    continue

                for k in range(4): 
                    nr = pr + dr[k]
                    nc = pc + dc[k]

                    if 0<=nr<4 and 0<=nc<4:
                        q.append((nr, nc, num+matrix[nr][nc]))

    print(f'#{tc} {len(numSet)}')
