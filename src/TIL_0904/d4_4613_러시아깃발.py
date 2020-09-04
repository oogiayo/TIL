T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    arr = [[] for _ in range(N)]
    
    cnts = [[0]*N for _ in range(3)]
    for r in range(0, N):
        for l in input():
            arr[r].append(l)
            if l == 'W':
                cnts[0][r] += 1
            elif l == 'B':
                cnts[1][r] += 1
            else:
                cnts[2][r] += 1

    max_same = 0
    for w in range(1, N-1):
        for b in range(1, N-w):
            cnt = 0
        
            cnt += sum(cnts[0][:w])
            cnt += sum(cnts[1][w:w+b])
            cnt += sum(cnts[2][w+b:])

            if cnt > max_same:
                max_same = cnt

    ans = N*M - max_same
    print(f'#{tc} {ans}')
