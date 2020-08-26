dc = [-1,1]

T = 10
for tc in range(1, T+1):
    t = int(input())
    
    ladder = [[] for r in range(0, 100)]
    for r in range(0, 100):
        line = list(map(int, input().split()))
        for c in range(0, 100):
            ladder[r].append(line[c])
            if line[c]==2:
                arrival_c = c
    
    pr = 99
    pc = arrival_c
    
    while True:
        flag = False
        if pr==0:
            print(f'#{t} {pc}')
            break
        for k in range(0, 2):
            nc = pc + dc[k]
            if 0<=nc<100 and ladder[pr][nc]==1:
                while True:
                    nc += dc[k]
                    if 0<=nc<100 and ladder[pr][nc]==1:
                        continue
                    else:
                        pc = nc - dc[k]
                        pr -= 1
                        flag = True
                        break
                continue
        if(flag==False):
            pr -= 1

