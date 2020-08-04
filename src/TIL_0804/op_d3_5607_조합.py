T = int(input())

for tc in range(1, T+1):
    N, R = map(int, input().split())
    nCr = 1
    for n in range(N, N-R, -1):
        nCr *= n
    for r in range(R, 0, -1):
        nCr //= r
    
    print(f'#{tc} {nCr % 1234567891}')