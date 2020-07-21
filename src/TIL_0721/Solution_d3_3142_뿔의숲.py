# Solution_d3_3142_뿔의숲
T = int(input())

for tc in range(1, T+1):
    N, M = map(int, input().split())
    for i in range(0, M+1):
        if i*1+(M-i)*2 == N:
            print(f'#{tc} {i} {M-i}')