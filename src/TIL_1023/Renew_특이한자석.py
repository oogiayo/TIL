# S극=1, N극=0

T = int(input())
for tc in range(1, T+1):
    K, N, M = map(int, input().split())
    gears = [list(map(int, input().split())) for _ in range(0, M)]
    
    for i in range(0, K):
        info = list(map(int, input().split()))
        num = info[0]-1
        direction = info[1]

        rotate = [0 for _ in range(0, M)]
        rotate[num] = direction
        
        # 좌측
        idx = 1
        while num-idx >= 0:
            if gears[num-idx+1][-N//4] != gears[num-idx][N//4]:
                rotate[num-idx] = direction*(-1)**idx
            else:
                break
            idx += 1

        # 우측
        idx = 1
        while num+idx < M:
            if gears[num+idx-1][N//4] != gears[num+idx][-N//4]:
                rotate[num+idx] = direction*(-1)**idx
            else:
                break
            idx += 1

        for change_num in range(0, M):
            if rotate[change_num]==1:
                gears[change_num] = [gears[change_num][N-1]] + gears[change_num][:N-1]
            elif rotate[change_num]==-1:
                gears[change_num] = gears[change_num][1:] + [gears[change_num][0]]
    
    score = 0
    for i in range(0, M):
        if gears[i][0]==1:
            score += 2**i
    print(f'#{tc} {score}')

