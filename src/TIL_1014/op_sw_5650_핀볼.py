from collections import deque

def play(r0, c0, k):
    q. append((r0, c0, 0))
    isFirst = True
    while q:
        pr, pc, score = q.popleft()
        # print(pr, pc, score)

        if score >= 18:
            print(r0, c0, k)
        # print(pr, pc, k, '점수', score)
        # 출발위치(r, c)로 돌아올 경우 게임종료
        if pr==r0 and pc==c0:
            if isFirst:
                isFirst = False
            else:
                # if score>1:
                #     print(r0, c0, score)
                return score
        
        # 같은 방향으로 지나갔던 곳이면 무한루프 => 0 리턴
        if visited[pr][pc][k]==True:
            return 0
        visited[pr][pc][k] = True

        nr = pr + dr[k]
        nc = pc + dc[k]
        if 0<=nr<N and 0<=nc<N:

            # 블랙홀(-1)에 빠질 경우 게임종료
            if mapp[nr][nc]==-1:
                return score
            
            # 웜홀을 만날 경우
            elif mapp[nr][nc]>=6:
                hole_num = mapp[nr][nc]
                if (nr, nc)==wormholes[hole_num][0]:
                    nr, nc = wormholes[hole_num][1]
                else:
                    nr, nc = wormholes[hole_num][0]
                q.append((nr, nc, score))

            elif mapp[nr][nc]==0:
                q.append((nr, nc, score))
            
            # 블럭에 부딪힐 경우
            else:
                if mapp[nr][nc]==1 and k==1:
                    k = 3
                elif mapp[nr][nc]==1 and k==2:
                    k = 0
                elif mapp[nr][nc]==2 and k==0:
                    k = 3
                elif mapp[nr][nc]==2 and k==2:
                    k = 1
                elif mapp[nr][nc]==3 and k==0:
                    k = 2
                elif mapp[nr][nc]==3 and k==3:
                    k = 1
                elif mapp[nr][nc]==4 and k==1:
                    k = 2
                elif mapp[nr][nc]==4 and k==3:
                    k = 0
                # 나머지 경우 -> 방향 반대        
                else:
                    if k==0 or k==2:
                        k += 1
                    else:
                        k -= 1
                    q.append((pr, pc, score+1))
                    continue
                q.append((nr, nc, score+1))    
                    
        # 벽을 만날 경우 -> 방향 반대
        else:
            if k==0 or k==2:
                k += 1
            else:
                k -= 1
            q.append((pr, pc, score+1))


dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    mapp = [[0]*N for _ in range(0, N)]
    startPoints = []
    wormholes = [[] for _ in range(0, 11)]
    for r in range(0, N):
        line = list(map(int, input().split()))
        for c in range(0, N):
            mapp[r][c] = line[c]

            if mapp[r][c] >= 6:
                hole_num = mapp[r][c]
                wormholes[hole_num].append((r, c))
            elif mapp[r][c] == 0:
                startPoints.append((r, c))

    ans = 0        
    # 초기 위치
    q = deque()
    for (r0, c0) in startPoints:        
        # 초기 방향
        for k in range(0, 4):
            visited = [[[False]*4 for _ in range(0, N)] for _ in range(0, N)]
            game_score = play(r0, c0, k)
            if game_score > ans:
                ans = game_score

    print(f'#{tc} {ans}')
