T = int(input())

for tc in range(1, T+1):
    N = int(input())
    pay = 0
    for i in range(0, N):
        p, x = map(float, input().split())
        pay += p*x

    print(f'#{tc} {pay:.6f}')