T = int(input())

for tc in range(1, T+1):
    N = int(input())

    while True:
        if len(str(N))==1:
            break
        else:
            ans = 0
            while N>0:
                ans += N%10
                N = N//10
            N = ans

    print(f'#{tc} {N}')