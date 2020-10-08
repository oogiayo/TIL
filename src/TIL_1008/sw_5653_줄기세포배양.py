from collections import deque

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

def simulation(K):
    global ans
    while q:
        pr, pc, lifecycle, activated, time, abs_time = q.popleft()
        time += 1
        abs_time += 1

        # 내 자리가 아닐 경우 ( 자리를 뺏긴 상태 )        
        if lifecycle != grid[pr][pc]:
            continue

        if abs_time == K+1:
            ans += 1
            continue

        if not activated:

            if lifecycle==time:
                q.append((pr, pc, lifecycle, True, 0, abs_time))
            else:
                q.append((pr, pc, lifecycle, False, time, abs_time))
            continue

        if activated:
            # 활성화된 후 1시간동안 번식
            if time==1:
                for k in range(0, 4):
                    nr = pr + dr[k]
                    nc = pc + dc[k]

                    # 빈자리일 경우
                    if visited[nr][nc] == 0:
                        grid[nr][nc] = lifecycle
                        visited[nr][nc] = abs_time
                        q.append((nr, nc, lifecycle, False, 0, abs_time))
                    # 동시에 번식 시도
                    elif visited[nr][nc]==abs_time:
                        # 비활성화된 세포의 자리는 번식 불가능
                        if grid[nr][nc]==-1:
                            continue
                        elif lifecycle > grid[nr][nc]:
                            grid[nr][nc] = lifecycle
                            q.append((nr, nc, lifecycle, False, 0, abs_time)) 
                    # 이전에 자리잡은 경우 or 나머지경우
                    else:
                        pass
                
            # 수명을 다하면 비활성화
            if time == lifecycle:
                grid[pr][pc] = -1

            # 원래 자리의 활성화된 세포는 aging 진행
            q.append((pr, pc, lifecycle, True, time, abs_time))
    

T = int(input())

for tc in range(1, T+1):
    N, M, K = map(int, input().split())
    
    q = deque()

    grid = [[0]*(M+2*K) for _ in range(0, N+2*K)]
    visited = [[0]*(M+2*K) for _ in range(0, N+2*K)]
    for r in range(0, N):
        line = list(map(int, input().split()))
        for c in range(0, M):
            grid[K+r][K+c] = line[c]
            if line[c] != 0:
                visited[K+r][K+c] = 1
                q.append((K+r, K+c, grid[K+r][K+c], False, 0, 0))
    
    ans = 0
    simulation(K)

    print(f'#{tc} {ans}')
