N, K = map(int, input().split())

rooms = [[0]*2 for _ in range(0, 7)]

cnt = 0
for i in range(0, N):
    S, Y = map(int, input().split())
    rooms[Y][S] += 1
    if rooms[Y][S]==1:
        cnt += 1
    elif rooms[Y][S]==K:
        rooms[Y][S] = 0
    
print(cnt)
