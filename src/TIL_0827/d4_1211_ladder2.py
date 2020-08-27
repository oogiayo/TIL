dc = [-1,1]

T = 10
for tc in range(1, T+1):
    t = int(input())
    
    ladder = [[] for r in range(0, 100)]
    for r in range(0, 100):
        line = list(map(int, input().split()))
        for c in range(0, 100):
            ladder[r].append(line[c])
    
    min_c0 = 100
    min_cnt = 10000
    for c0 in range(0, 100):
        pc = c0
        pr = 0
        if ladder[pr][pc]==1:
            cnt = 0
            while True:
                sideGo = False
                if pr==99:
                    # print(c0, cnt)
                    # print(c0, pc)
                    if cnt < min_cnt:
                        min_cnt = cnt
                        min_c0 = c0
                    break
                for k in range(0, 2):
                    nc = pc + dc[k]
                    if 0<=nc<100 and ladder[pr][nc]==1:
                        sideGo = True
                        while True:
                            # print(nc, pr)
                            nc += dc[k]            
                            if 0<=nc<100 and ladder[pr][nc]==1:
                                cnt += 1
                                continue
                            else:
                                pc = nc - dc[k]
                                pr += 1
                                cnt += 1
                                break
                        break

                if sideGo==False:
                    pr += 1
                    cnt += 1
                    
    print(f'#{tc} {min_c0}')
