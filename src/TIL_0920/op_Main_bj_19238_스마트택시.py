from collections import deque

def findPerson(r0, c0, fuel0):
    q = deque()
    q.append((r0, c0, fuel0))
    visited = [[False]*N for _ in range(0, N)]
    visited[r0][c0] = True
    
    find = 0
    while q:
        pr, pc, fuel = q.popleft()
        if fuel==0:
            return None
        if maps[pr][pc][0]!=0 and maps[pr][pc][0]%2==0 and fuel >= find:
                    endpoint = maps[pr][pc][0] + 1
                    # print("기사님 출발해주세요")
                    if waiting:
                        if waiting[0][0] > pr:
                            waiting[0] = (pr, pc, fuel, endpoint)
                        elif waiting[0][0] == pr:
                            if waiting[0][1] > pc:
                                waiting[0] = (pr, pc, fuel, endpoint)
                    else:                            
                        waiting.append((pr, pc, fuel, endpoint))
                    find = fuel

        for k in range(0, 4):
            nr = pr + dr[k]
            nc = pc + dc[k]
            if 0<=nr<N and 0<=nc<N and visited[nr][nc]==False:
                # print(nr, nc, fuel-1, '빈차')
                

                if maps[nr][nc][0]!=1:
                    visited[nr][nc] = True
                    q.append((nr, nc, fuel-1))
    return None


def goDestination(r0, c0, fuel0, endpoint):
    global people
    q = deque()
    q.append((r0, c0, fuel0, 0))
    visited = [[False]*N for _ in range(0, N)]
    visited[r0][c0] = True

    while q:
        pr, pc, fuel, fare = q.popleft()
        # print(pr, pc, fuel, fare, '운행중')
        if maps[pr][pc][1]==endpoint:
            # maps[nr][nc] = 0
            people -= 1
            # print(pr, pc, '조심히가세요')
            return (pr, pc, fuel + fare*2)
        if fuel==0:
            return None

        for k in range(0, 4):
            nr = pr + dr[k]
            nc = pc + dc[k]
            
            if 0<=nr<N and 0<=nc<N and visited[nr][nc]==False:
                
                if maps[nr][nc]!=1:
                    visited[nr][nc] = True
                    q.append((nr, nc, fuel-1, fare+1))
    return None

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

N, M, fuel0 = map(int, input().split())

# maps = [list(map(int, input().split())) for _ in range(0, N)]
maps = [[[0, 0] for _ in range(0, N)] for _ in range(0, N)]
for r in range(0, N):
    line = list(map(int, input().split()))
    for c in range(0, N):
        maps[r][c][0] = line[c]
        maps[r][c][1] = line[c]


r0, c0 = map(int, input().split())
r0 -= 1
c0 -= 1


for i in range(0, M):
    info = list(map(int, input().split()))
    maps[info[0]-1][info[1]-1][0] = i*2 + 2
    maps[info[2]-1][info[3]-1][1] = i*2 + 3
    
# for r in range(0, N):
    # print(maps[r])


people = M
for i in range(0, M):
    # print('#', i+1)
    waiting = []        
    findPerson(r0, c0, fuel0)

    if waiting:
        r0, c0, fuel0, endpoint = waiting[0]
        success = goDestination(r0, c0, fuel0, endpoint)
        if success:
            r0, c0, fuel0 = success
        else:
            fuel0 = -1
            break
    else:
        fuel0 = -1
        break
    maps[waiting[0][0]][waiting[0][1]][0] = 0

if people!=0:
    fuel0 = -1
print(fuel0)


# 6 4 15
# 0 0 1 0 0 0
# 0 0 1 0 0 0
# 0 0 0 0 0 0
# 0 0 0 0 0 0
# 0 0 0 0 1 0
# 0 0 0 1 0 0
# 6 5
# 2 2 5 6
# 5 4 1 6
# 4 2 3 5
# 1 6 5 4
