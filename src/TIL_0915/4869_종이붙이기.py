def paper(n):
    if ans[n] > 0:
        return ans[n]
    elif n==1:
        return 1
    elif n==2:
        return 3
    else:
        ans[n] = paper(n-1) + 2*paper(n-2)
        return ans[n]

ans = [0]*31

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    if ans[N//10] > 0:
        print(f'#{tc} {ans[N//10]}')
    else:
        print(f'#{tc} {paper(N//10)}')
