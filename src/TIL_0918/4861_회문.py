T = int(input())
for tc in range(1,T+1):
    N, M = map(int, input().split())
    arr = [[] for r in range(0, N)]
    for r in range(0, N):
        line = input()
        for c in range(0, N):
            arr[r].append(line[c])

    print(f'#{tc}', end=' ')
    breaker = False
    for r0 in range(0, N):
        for c0 in range(0, N):  
            if r0+M-1 < N:
                next = False
                for i in range(0, M//2):
                    if arr[r0+i][c0]!=arr[r0+M-1-i][c0]:
                        next = True
                        break
                if next:
                    continue
                else:
                    for i in range(0, M):
                        print(arr[r0+i][c0], end='')
                    print()
                    breaker = True
                    break

            if c0+M-1 < N:
                next = False
                for i in range(0, M//2):
                    if arr[r0][c0+i]!=arr[r0][c0+M-1-i]:
                        next = True
                        break
                if next:
                    continue
                else:
                    for i in range(0, M):
                        print(arr[r0][c0+i], end='')
                    print()
                    breaker = True
                    break
            
        if breaker:
            break
