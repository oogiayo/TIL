N, K = map(int, input().split())

rooms = [[0]*2 for _ in range(0, 7)]
cnt = 0
for i in range(0, N):
    S, Y = map(int, input().split())
    rooms[Y][S] += 1
    if rooms[Y][S]==K:
        rooms[Y][S] = 0
        cnt += 1
    
for s in range(0, 2):
    for y in range(1, 7):
        if rooms[y][s]:
            cnt += 1

print(cnt)
