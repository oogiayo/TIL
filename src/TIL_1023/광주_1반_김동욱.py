# S극=1, N극=0

N = int(input())
gears = [[0]*8 for _ in range(0, N)]
for r in range(0, N):
    line = input()
    for c in range(0, 8):
        gears[r][c] = int(line[c])

K = int(input())

for i in range(0, K):
    info = list(map(int, input().split()))
    num = info[0]-1
    direction = info[1]

    rotate = [0 for _ in range(0, N)]
    rotate[num] = direction
    
    # 좌측
    idx = 1
    while num-idx >= 0:
        if gears[num-idx+1][-2] != gears[num-idx][2]:
            rotate[num-idx] = direction*(-1)**idx
        else:
            break
        idx += 1

    # 우측
    idx = 1
    while num+idx < N:
        if gears[num+idx-1][2] != gears[num+idx][-2]:
            rotate[num+idx] = direction*(-1)**idx
        else:
            break
        idx += 1

    for change_num in range(0, N):
        if rotate[change_num]==1:
            gears[change_num] = [gears[change_num][7]] + gears[change_num][:7]
        elif rotate[change_num]==-1:
            gears[change_num] = gears[change_num][1:] + [gears[change_num][0]]

ans = 0
for i in range(0, N):
    if gears[i][0]==1:
        ans += 1
print(f'{ans}')

